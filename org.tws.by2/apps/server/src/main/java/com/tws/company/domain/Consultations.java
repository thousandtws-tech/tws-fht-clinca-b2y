package com.tws.company.domain;

import com.tws.company.domain.enums.UserStatus;

public class Consultations {
    @Id
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Keyword)
    @Column("id")
    private String id;

    String appointmentId;
    String patientId;
    String doctorId;
    String telemedicineLink;
    UserStatus status;
    Number totalMaterialCost;
}
