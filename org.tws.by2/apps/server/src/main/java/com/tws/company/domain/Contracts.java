package com.tws.company.domain;

import com.tws.company.domain.enums.UserStatus;
import com.tws.company.domain.enums.UserType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Contracts {
    @Id
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Keyword)
    @Column("id")
    private String id;

    String shiftRequirementId;
    String doctorId;
    String hospitalId;
    String doctorName;
    String hospitalName;
    List<String> specialties;
    List<LocalDate> shiftDates;
    LocalTime startTime;
    LocalTime endTime;
    BigDecimal doctorRate;
    UserType serviceType;
    UserStatus status;
    String contractPdfPath;
    String telemedicineLink;
}
