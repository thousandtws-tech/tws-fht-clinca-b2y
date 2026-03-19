package com.tws.company.domain;

import com.tws.company.domain.enums.UserStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PotentialMatchers {
    @Id
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Keyword)
    @Column("id")
    String id;
    String shiftRequirementId;
    String timeSlotId;
    String doctorId;
    String hospitalId;
    LocalDate matchedDate;
    BigDecimal matchScore;
    UserStatus status;
    BigDecimal offeredRateByHospital;
    BigDecimal doctorDesiredRate;
}
