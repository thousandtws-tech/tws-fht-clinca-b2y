package com.tws.company.domain.enums;

public enum ShiftRequirementStatus implements DatabaseEnum {
    OPEN("OPEN"),
    CONFIRMED("CONFIRMED"),
    CANCELLED("CANCELLED");

    private final String value;

    ShiftRequirementStatus(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
