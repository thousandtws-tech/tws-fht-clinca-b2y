package com.tws.company.domain.enums;

public enum ContractStatus implements DatabaseEnum {
    DRAFT("DRAFT"),
    PENDING_SIGNATURE("PENDING_SIGNATURE"),
    ACTIVE_SIGNED("ACTIVE_SIGNED"),
    IN_PROGRESS("IN_PROGRESS"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED");

    private final String value;

    ContractStatus(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
