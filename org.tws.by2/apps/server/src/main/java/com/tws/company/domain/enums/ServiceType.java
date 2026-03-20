package com.tws.company.domain.enums;

public enum ServiceType implements DatabaseEnum {
    TELEMEDICINA("Telemedicina"),
    PRESENCIAL("Presencial"),
    PLANTAO("Plantao");

    private final String value;

    ServiceType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
