package com.tws.company.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;

public class Patient {
    @Id
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Keyword)
    @Column("id")
    private String id;
    String cpf;
    String name;
    LocalDate DateOfBirth;
    String phone;
    String email;
}
