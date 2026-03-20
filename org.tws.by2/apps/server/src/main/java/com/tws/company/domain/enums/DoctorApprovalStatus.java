package com.tws.company.domain.enums;

public enum DoctorApprovalStatus implements DatabaseEnum {
    PENDING_REVIEW("PENDING_REVIEW"),
    APPROVED("APPROVED"),
    REJECTED("REJECTED");

    private final String value;

    DoctorApprovalStatus(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
