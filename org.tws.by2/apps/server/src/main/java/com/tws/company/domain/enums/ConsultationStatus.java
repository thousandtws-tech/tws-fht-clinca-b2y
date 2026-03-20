package com.tws.company.domain.enums;

public enum ConsultationStatus implements DatabaseEnum {
    SCHEDULED("SCHEDULED"),
    IN_PROGRESS("IN_PROGRESS"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED");

    private final String value;

    ConsultationStatus(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
