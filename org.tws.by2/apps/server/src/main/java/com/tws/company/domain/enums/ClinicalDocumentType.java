package com.tws.company.domain.enums;

public enum ClinicalDocumentType implements DatabaseEnum {
    MEDICAL_CERTIFICATE("medicalCertificate"),
    ATTENDANCE_CERTIFICATE("attendanceCertificate");

    private final String value;

    ClinicalDocumentType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
