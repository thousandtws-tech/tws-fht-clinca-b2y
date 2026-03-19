package com.tws.company.domain;

import com.tws.company.domain.enums.UserStatus;
import com.tws.company.domain.enums.UserType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DoctorTimeSlots {
    @Id
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Keyword)
    @Column("id")
    private String id;

    String doctorId;
    String doctorName;
    LocalDate date;
    LocalTime startTime;
    LocalTime endTime;
    Boolean isOvernight;
    UserType serviceType;
    List<String>  specialties;
    BigDecimal desiredHourlyRate;
    UserStatus status;
    String notes;
    List<String> cities;
    List<String> state;
}
