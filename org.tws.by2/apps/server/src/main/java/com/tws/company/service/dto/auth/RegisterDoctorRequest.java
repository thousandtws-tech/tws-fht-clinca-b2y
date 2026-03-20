package com.tws.company.service.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

public record RegisterDoctorRequest(
    @NotBlank @Email String email,
    @NotBlank String password,
    String displayName,
    String displayNameLowercase,
    String userType,
    String status,
    String documentVerificationStatus,
    Boolean activated,
    @NotBlank String professionalCrm,
    String crmState,
    BigDecimal desiredHourlyRate,
    String approvalStatus
) {}
