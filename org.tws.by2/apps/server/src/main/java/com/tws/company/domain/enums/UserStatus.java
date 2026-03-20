package com.tws.company.domain.enums;

public enum UserStatus implements DatabaseEnum {
    INVITED("INVITED"),
    ACTIVE("ACTIVE"),
    PENDING_APPROVAL("PENDING_APPROVAL"),
    SUSPENDED("SUSPENDED");

    private final String value;

    UserStatus(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
