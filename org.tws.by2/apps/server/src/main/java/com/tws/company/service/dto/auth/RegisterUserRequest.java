package com.tws.company.service.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterUserRequest(
    @NotBlank @Email String email,
    @NotBlank String password,
    String displayName,
    String displayNameLowercase,
    String userType,
    String status,
    String documentVerificationStatus,
    Boolean activated
) {}
