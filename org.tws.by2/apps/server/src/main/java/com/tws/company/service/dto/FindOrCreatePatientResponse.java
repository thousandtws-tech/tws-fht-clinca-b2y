package com.tws.company.service.dto;

import java.util.UUID;

public record FindOrCreatePatientResponse(UUID patientId, boolean isNew) {}
