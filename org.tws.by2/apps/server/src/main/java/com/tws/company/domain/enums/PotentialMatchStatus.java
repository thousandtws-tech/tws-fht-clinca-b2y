package com.tws.company.domain.enums;

public enum PotentialMatchStatus implements DatabaseEnum {
    PENDING_BACKOFFICE_REVIEW("PENDING_BACKOFFICE_REVIEW"),
    APPROVED("APPROVED"),
    REJECTED("REJECTED"),
    CONTRACTED("CONTRACTED");

    private final String value;

    PotentialMatchStatus(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
