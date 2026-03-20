package com.tws.company.service.dto.auth;

import java.util.UUID;

public record AuthResponse(
    String accessToken,
    String refreshToken,
    String tokenType,
    long expiresIn,
    long refreshExpiresIn,
    String scope,
    String keycloakUserId,
    UUID userAccountId,
    UUID doctorProfileId,
    UUID hospitalProfileId
) {}
