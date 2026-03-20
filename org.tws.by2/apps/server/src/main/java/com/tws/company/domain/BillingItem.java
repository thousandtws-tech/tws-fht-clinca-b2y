package com.tws.company.domain;

import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("billing_item")
public class BillingItem extends AbstractAuditingUuidEntity {

    @Column("consultation_id")
    private UUID consultationId;

    @Column("product_id")
    private UUID productId;

    @Column("recorded_by_user_account_id")
    private UUID recordedByUserAccountId;

    @Column("product_name")
    private String productName;

    @Column("quantity_used")
    private Integer quantityUsed;

    @Column("unit_cost_at_time")
    private BigDecimal unitCostAtTime;

    @Column("total_cost")
    private BigDecimal totalCost;

    public UUID getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(UUID consultationId) {
        this.consultationId = consultationId;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public UUID getRecordedByUserAccountId() {
        return recordedByUserAccountId;
    }

    public void setRecordedByUserAccountId(UUID recordedByUserAccountId) {
        this.recordedByUserAccountId = recordedByUserAccountId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(Integer quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public BigDecimal getUnitCostAtTime() {
        return unitCostAtTime;
    }

    public void setUnitCostAtTime(BigDecimal unitCostAtTime) {
        this.unitCostAtTime = unitCostAtTime;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
}
