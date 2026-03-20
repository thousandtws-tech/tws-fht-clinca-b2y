package com.tws.company.service.dto;

import java.util.UUID;

public record CreateAppointmentResponse(UUID appointmentId, String roomUrl) {}
