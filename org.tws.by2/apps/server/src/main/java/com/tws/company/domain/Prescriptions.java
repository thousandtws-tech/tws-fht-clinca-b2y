package com.tws.company.domain;

public class Prescriptions {
    @Id
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Keyword)
    @Column("id")
    private String id;

    String consultationId;
    String patientName;
    String doctorName;
    String doctorCrm;
    String pdfPath;
}
