package com.tws.company.service.dto;

import java.time.Instant;
import java.util.UUID;

public record CreateAppointmentRequest(
    UUID patientId,
    String patientName,
    UUID doctorProfileId,
    String doctorName,
    String specialty,
    Instant appointmentDate,
    String appointmentType,
    UUID createdByUserAccountId
) {}
