package com.tws.company.domain.enums;

public enum HealthUnitDoctorLinkType implements DatabaseEnum {
    MANUAL("MANUAL"),
    CONTRACT("CONTRACT"),
    INVITATION("INVITATION");

    private final String value;

    HealthUnitDoctorLinkType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
