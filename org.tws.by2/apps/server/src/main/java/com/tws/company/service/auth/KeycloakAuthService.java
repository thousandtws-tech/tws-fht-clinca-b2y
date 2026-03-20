package com.tws.company.service.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Service
public class KeycloakAuthService {

    private final WebClient webClient;
    private final String issuerUri;
    private final String oidcClientId;
    private final String oidcClientSecret;
    private final String adminClientId;
    private final String adminClientSecret;
    private final String realm;
    private final String serverBaseUrl;

    public KeycloakAuthService(
        WebClient.Builder webClientBuilder,
        @Value("${spring.security.oauth2.client.provider.oidc.issuer-uri}") String issuerUri,
        @Value("${spring.security.oauth2.client.registration.oidc.client-id}") String oidcClientId,
        @Value("${spring.security.oauth2.client.registration.oidc.client-secret:}") String oidcClientSecret,
        @Value("${application.security.keycloak.admin-client-id:}") String adminClientId,
        @Value("${application.security.keycloak.admin-client-secret:}") String adminClientSecret,
        @Value("${application.security.keycloak.realm:}") String configuredRealm
    ) {
        this.webClient = webClientBuilder.build();
        this.issuerUri = issuerUri;
        this.oidcClientId = oidcClientId;
        this.oidcClientSecret = oidcClientSecret;
        this.adminClientId = adminClientId.isBlank() ? oidcClientId : adminClientId;
        this.adminClientSecret = adminClientSecret.isBlank() ? oidcClientSecret : adminClientSecret;
        this.realm = configuredRealm.isBlank() ? extractRealm(issuerUri) : configuredRealm;
        this.serverBaseUrl = extractServerBaseUrl(issuerUri);
    }

    public Mono<KeycloakTokenResponse> login(String username, String password) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "password");
        formData.add("client_id", oidcClientId);
        if (!oidcClientSecret.isBlank()) {
            formData.add("client_secret", oidcClientSecret);
        }
        formData.add("username", username);
        formData.add("password", password);

        return webClient
            .post()
            .uri(getTokenEndpoint())
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(BodyInserters.fromFormData(formData))
            .retrieve()
            .onStatus(HttpStatusCode::isError, this::mapLoginError)
            .bodyToMono(KeycloakTokenResponse.class);
    }

    public Mono<String> createUser(String username, String email, String password, String roleName) {
        return getAdminAccessToken().flatMap(adminToken -> doCreateUser(adminToken, username, email, password).flatMap(userId ->
            getRealmRole(roleName, adminToken).flatMap(role -> assignRealmRoleToUser(adminToken, userId, role).thenReturn(userId))
        ));
    }

    public Mono<Void> deleteUser(String keycloakUserId) {
        return getAdminAccessToken()
            .flatMap(token ->
                webClient
                    .delete()
                    .uri(getAdminUsersEndpoint() + "/" + keycloakUserId)
                    .headers(headers -> headers.setBearerAuth(token))
                    .retrieve()
                    .onStatus(HttpStatusCode::isError, this::mapAdminError)
                    .toBodilessEntity()
                    .then()
            );
    }

    private Mono<String> doCreateUser(String adminToken, String username, String email, String password) {
        Map<String, Object> payload = Map.of(
            "username",
            username,
            "email",
            email,
            "enabled",
            true,
            "emailVerified",
            true,
            "credentials",
            List.of(Map.of("type", "password", "value", password, "temporary", false))
        );

        return webClient
            .post()
            .uri(getAdminUsersEndpoint())
            .headers(headers -> headers.setBearerAuth(adminToken))
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(payload)
            .exchangeToMono(this::extractCreatedUserId);
    }

    private Mono<String> getAdminAccessToken() {
        if (adminClientSecret.isBlank()) {
            return Mono.error(
                new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Client secret do Keycloak nao configurado para operacoes administrativas"
                )
            );
        }

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "client_credentials");
        formData.add("client_id", adminClientId);
        formData.add("client_secret", adminClientSecret);

        return webClient
            .post()
            .uri(getTokenEndpoint())
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(BodyInserters.fromFormData(formData))
            .retrieve()
            .onStatus(HttpStatusCode::isError, this::mapAdminError)
            .bodyToMono(KeycloakTokenResponse.class)
            .map(KeycloakTokenResponse::accessToken);
    }

    private Mono<KeycloakRoleRepresentation> getRealmRole(String roleName, String adminToken) {
        return webClient
            .get()
            .uri(getAdminRolesEndpoint() + "/" + roleName)
            .headers(headers -> headers.setBearerAuth(adminToken))
            .retrieve()
            .onStatus(HttpStatusCode::isError, this::mapAdminError)
            .bodyToMono(KeycloakRoleRepresentation.class);
    }

    private Mono<Void> assignRealmRoleToUser(String adminToken, String userId, KeycloakRoleRepresentation role) {
        return webClient
            .post()
            .uri(getAdminUsersEndpoint() + "/" + userId + "/role-mappings/realm")
            .headers(headers -> headers.setBearerAuth(adminToken))
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(List.of(Map.of("id", role.id(), "name", role.name())))
            .retrieve()
            .onStatus(HttpStatusCode::isError, this::mapAdminError)
            .toBodilessEntity()
            .then();
    }

    private Mono<String> extractCreatedUserId(ClientResponse response) {
        if (response.statusCode().is2xxSuccessful()) {
            URI location = response.headers().asHttpHeaders().getLocation();
            if (location == null) {
                return Mono.error(
                    new ResponseStatusException(
                        HttpStatus.BAD_GATEWAY,
                        "Keycloak nao retornou o ID do usuario criado no header Location"
                    )
                );
            }
            String path = location.getPath();
            return Mono.just(path.substring(path.lastIndexOf('/') + 1));
        }
        return response
            .bodyToMono(String.class)
            .defaultIfEmpty("")
            .flatMap(body -> {
                if (response.statusCode().value() == HttpStatus.CONFLICT.value()) {
                    return Mono.error(new ResponseStatusException(HttpStatus.CONFLICT, "Usuario ja existe no Keycloak"));
                }
                return Mono.error(new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Falha ao criar usuario no Keycloak: " + body));
            });
    }

    private Mono<? extends Throwable> mapLoginError(ClientResponse response) {
        return response
            .bodyToMono(String.class)
            .defaultIfEmpty("")
            .flatMap(body ->
                Mono.error(new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciais invalidas no Keycloak: " + body))
            );
    }

    private Mono<? extends Throwable> mapAdminError(ClientResponse response) {
        return response
            .bodyToMono(String.class)
            .defaultIfEmpty("")
            .flatMap(body ->
                Mono.error(new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Falha em operacao administrativa no Keycloak: " + body))
            );
    }

    private String getTokenEndpoint() {
        return issuerUri + "/protocol/openid-connect/token";
    }

    private String getAdminUsersEndpoint() {
        return serverBaseUrl + "/admin/realms/" + realm + "/users";
    }

    private String getAdminRolesEndpoint() {
        return serverBaseUrl + "/admin/realms/" + realm + "/roles";
    }

    private static String extractRealm(String issuer) {
        URI uri = URI.create(issuer);
        String path = uri.getPath();
        String marker = "/realms/";
        int markerIndex = path.indexOf(marker);
        if (markerIndex < 0 || markerIndex + marker.length() >= path.length()) {
            throw new IllegalStateException("Nao foi possivel extrair o realm do issuer-uri: " + issuer);
        }
        return path.substring(markerIndex + marker.length());
    }

    private static String extractServerBaseUrl(String issuer) {
        URI uri = URI.create(issuer);
        return uri.getScheme() + "://" + uri.getAuthority();
    }

    public record KeycloakTokenResponse(
        @JsonProperty("access_token") String accessToken,
        @JsonProperty("refresh_token") String refreshToken,
        @JsonProperty("token_type") String tokenType,
        @JsonProperty("expires_in") long expiresIn,
        @JsonProperty("refresh_expires_in") long refreshExpiresIn,
        String scope
    ) {}

    private record KeycloakRoleRepresentation(String id, String name) {}
}
