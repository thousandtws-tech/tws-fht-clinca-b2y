package com.tws.company.domain.enums;

public enum AppointmentStatus implements DatabaseEnum {
    SCHEDULED("SCHEDULED"),
    CONFIRMED("CONFIRMED"),
    CANCELLED("CANCELLED"),
    COMPLETED("COMPLETED");

    private final String value;

    AppointmentStatus(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
