package com.tws.company.domain;

import com.tws.company.domain.enums.UserType;

public class ClinicalDocuments {
    @Id
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Keyword)
    @Column("id")
    private String id;
    String consultationId;
    UserType type;
    String patientName;
    String doctorName;
    String doctorCrm;
    String details;
    String pdfPath;
}
