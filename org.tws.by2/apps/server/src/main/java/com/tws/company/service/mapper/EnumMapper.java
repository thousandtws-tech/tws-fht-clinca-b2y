package com.tws.company.service.mapper;

import com.tws.company.domain.enums.DatabaseEnum;

public final class EnumMapper {

    private EnumMapper() {}

    public static <E extends Enum<E> & DatabaseEnum> String toValue(E value) {
        return value == null ? null : value.getValue();
    }

    public static <E extends Enum<E> & DatabaseEnum> boolean equalsValue(String rawValue, E expected) {
        return rawValue != null && expected != null && rawValue.equalsIgnoreCase(expected.getValue());
    }
}
