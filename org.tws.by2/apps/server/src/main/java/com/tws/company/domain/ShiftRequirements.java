package com.tws.company.domain;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class ShiftRequirements {
    String hospitalId;
    String hospitalName;
    Timestamp[] dates;
    String startTime;
    String endTime;
    Boolean isOvernight;
    String serviceType;
    String specialtiesRequired;
    Integer offeredRate;
    Integer numberOfVacancies;
    String status;
    String notes;
    List<String> cities;
    String state;
}
