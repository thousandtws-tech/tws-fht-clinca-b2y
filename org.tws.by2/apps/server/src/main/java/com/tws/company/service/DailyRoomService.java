package com.tws.company.service;

import java.time.Instant;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DailyRoomService {

    private final WebClient webClient;

    @Value("${DAILY_APIKEY:}")
    private String dailyApiKey;

    public DailyRoomService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.daily.co/v1").build();
    }

    public Mono<String> createRoom(Instant expiration, boolean enableScreenshare) {
        if (dailyApiKey == null || dailyApiKey.isBlank()) {
            return Mono.error(new IllegalStateException("DAILY_APIKEY nao configurada."));
        }

        Map<String, Object> body = Map.of(
            "properties",
            Map.of("exp", expiration.getEpochSecond(), "enable_chat", true, "enable_screenshare", enableScreenshare)
        );

        return webClient
            .post()
            .uri("/rooms")
            .header(HttpHeaders.AUTHORIZATION, "Bearer " + dailyApiKey)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(body)
            .retrieve()
            .bodyToMono(Map.class)
            .map(response -> String.valueOf(response.get("url")));
    }
}
