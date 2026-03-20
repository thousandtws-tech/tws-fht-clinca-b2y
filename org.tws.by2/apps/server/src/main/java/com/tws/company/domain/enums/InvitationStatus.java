package com.tws.company.domain.enums;

public enum InvitationStatus implements DatabaseEnum {
    PENDING("pending"),
    COMPLETED("completed"),
    EXPIRED("expired"),
    CANCELLED("cancelled");

    private final String value;

    InvitationStatus(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
