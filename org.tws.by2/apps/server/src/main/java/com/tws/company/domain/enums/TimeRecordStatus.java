package com.tws.company.domain.enums;

public enum TimeRecordStatus implements DatabaseEnum {
    IN_PROGRESS("IN_PROGRESS"),
    COMPLETED("COMPLETED");

    private final String value;

    TimeRecordStatus(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
