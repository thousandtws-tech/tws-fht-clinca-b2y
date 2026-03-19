package com.tws.company.domain;

import java.util.List;

public class Contracts {
    @Id
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Keyword)
    @Column("id")
    private String id;

    String shiftRequirementId
    String doctorId
    String hospitalId
    String doctorName
    String hospitalName
    List<String> specialties
    shiftDates
    startTime
    endTime
    doctorRate
    serviceType
    status
    contractPdfPath
    telemedicineLink;
}
