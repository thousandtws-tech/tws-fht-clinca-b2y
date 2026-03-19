# Documentacao do Modulo de Autenticacao (Backend)

Este documento descreve como a autenticacao funciona hoje no backend `apps/server`, usando OAuth2/OpenID Connect com Keycloak.

## Visao Geral

O backend atua em dois papeis:

- `oauth2Login`: login de usuario via OIDC (redirecionamento para o provedor de identidade).
- `oauth2ResourceServer`: validacao de JWT em requisicoes para APIs protegidas.

Arquivos principais:

- `apps/server/src/main/java/com/tws/company/config/SecurityConfiguration.java`
- `apps/server/src/main/java/com/tws/company/config/OAuth2Configuration.java`
- `apps/server/src/main/java/com/tws/company/security/SecurityUtils.java`
- `apps/server/src/main/java/com/tws/company/security/oauth2/AudienceValidator.java`
- `apps/server/src/main/java/com/tws/company/service/UserService.java`
- `apps/server/src/main/java/com/tws/company/web/filter/OAuth2ReactiveRefreshTokensWebFilter.java`
- `apps/server/src/main/java/com/tws/company/web/rest/AuthInfoResource.java`

## Provedor OIDC (Keycloak)

Para desenvolvimento local, existe compose com Keycloak e import de realm:

- `apps/server/src/main/docker/keycloak.yml`
- `apps/server/src/main/docker/realm-config/jhipster-realm.json`

Configuracao OIDC usada pelo backend (issuer/client) em dev:

- `apps/server/src/main/resources/config/application-secret-samples.yml`
- `apps/server/src/main/resources/config/application.yml`

## Regras de Seguranca e Rotas

Definidas em `SecurityConfiguration`:

- Publicas: `/api/authenticate`, `/api/auth-info`, health/info de management.
- Protegidas: `/api/**`, `/services/**`.
- `/api/admin/**` exige `ROLE_ADMIN`.

## Validacao de Token

O backend valida:

- `issuer` do token.
- `audience` via `AudienceValidator` com base em `jhipster.security.oauth2.audience`.

Se a `audience` nao for aceita, o token e rejeitado.

## Mapeamento de Roles

As authorities sao extraidas das claims:

- `groups`
- `roles`
- `https://www.jhipster.tech/roles`

Somente valores iniciando com `ROLE_` viram authority do Spring Security.

## Sincronizacao do Usuario Local

No `UserService`, ao autenticar:

- Le claims do token (`preferred_username`, `email`, `given_name`, `family_name` etc.).
- Cria/atualiza usuario no banco local.
- Sincroniza authorities vindas do IdP.

## Refresh de Token

Filtro `OAuth2ReactiveRefreshTokensWebFilter` usa `ReactiveOAuth2AuthorizedClientManager` para renovar token quando necessario.

## Endpoint de Informacoes de Auth

Endpoint existente:

- `GET /api/auth-info`

Retorna `issuer` e `clientId` configurados, consumidos pelo frontend.

## Fluxograma Atual

```mermaid
flowchart TD
  A[Cliente / Frontend] -->|GET /api/auth-info| B[AuthInfoResource]
  B --> B1[Retorna issuer + clientId]

  A -->|Acessa /api/**| C[SecurityWebFilterChain]
  C -->|Rota publica| D[Permite acesso]
  C -->|Rota protegida| E{Autenticado?}
  E -->|Nao| F[Redireciona para IdP OIDC]
  F --> G[Keycloak OIDC]
  G -->|Login OK| H[Callback /login/oauth2/code/oidc]
  H --> I[OAuth2 Login]
  I --> J[Cria sessao + tokens]

  E -->|Sim (token JWT)| K[OAuth2 Resource Server]
  K --> L[JwtDecoder + AudienceValidator]
  L -->|OK| M[SecurityUtils: roles]
  M --> N[UserService: sync user/roles]
  N --> O[API Controller]

  O --> P[OAuth2ReactiveRefreshTokensWebFilter]
  P --> Q[ReactiveOAuth2AuthorizedClientManager]
  Q --> R[Refresh token se necessario]
```

## Observacoes Tecnicas

- A aplicacao foi gerada com JHipster e usa Spring WebFlux (reativo).
- O fluxo atual mistura sessao de login OIDC e acesso por JWT para APIs protegidas.
