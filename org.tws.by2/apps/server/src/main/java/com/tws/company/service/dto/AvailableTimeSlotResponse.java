package com.tws.company.service.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record AvailableTimeSlotResponse(
    UUID doctorTimeSlotId,
    UUID doctorProfileId,
    String doctorName,
    LocalDate slotDate,
    LocalTime startTime,
    LocalTime endTime
) {}
