package com.tws.company.domain;

public class BillingItem {
    @Id
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Keyword)
    @Column("id")
    private String id;

    String consultationId;
    String productId;
    String productName;
    Integer quantityUsed;
    Integer unitCostAtTime;
    Integer totalCost;
    String recordedByUserId;
}
