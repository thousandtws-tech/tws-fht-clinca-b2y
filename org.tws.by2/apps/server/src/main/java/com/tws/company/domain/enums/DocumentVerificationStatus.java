package com.tws.company.domain.enums;

public enum DocumentVerificationStatus implements DatabaseEnum {
    NOT_APPLICABLE("NOT_APPLICABLE"),
    PENDING_REVIEW("PENDING_REVIEW"),
    APPROVED("APPROVED"),
    REJECTED("REJECTED");

    private final String value;

    DocumentVerificationStatus(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
