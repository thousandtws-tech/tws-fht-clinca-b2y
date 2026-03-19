package com.tws.company.domain.enums;

public enum AppointmentType implements DatabaseEnum {
    TELEMEDICINA("Telemedicina"),
    PRESENCIAL("Presencial");

    private final String value;

    AppointmentType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
