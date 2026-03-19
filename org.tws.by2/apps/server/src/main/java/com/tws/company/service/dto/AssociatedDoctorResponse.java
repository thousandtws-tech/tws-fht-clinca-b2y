package com.tws.company.service.dto;

import java.util.List;
import java.util.UUID;

public record AssociatedDoctorResponse(UUID doctorProfileId, UUID userAccountId, String name, String crm, String email, List<String> specialties) {}
