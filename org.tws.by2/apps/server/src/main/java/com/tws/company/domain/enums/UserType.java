package com.tws.company.domain.enums;

public enum UserType implements DatabaseEnum {
    DOCTOR("doctor"),
    HOSPITAL("hospital"),
    ADMIN("admin"),
    RECEPTIONIST("receptionist"),
    TRIAGE_NURSE("triage_nurse"),
    CARAVAN_ADMIN("caravan_admin");

    private final String value;

    UserType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
