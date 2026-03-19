package com.tws.company.domain;

import com.tws.company.domain.enums.UserStatus;

public class Products {
    @Id
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Keyword)
    @Column("id")
    private String id;

    String name;
    String costPerUnit;
    UserStatus status;
    String BillingItem;
}
