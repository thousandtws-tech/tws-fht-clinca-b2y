package com.tws.company.domain;

import java.math.BigDecimal;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("doctor_profile")
public class DoctorProfile extends AbstractAuditingUuidEntity {

    @Column("user_account_id")
    private java.util.UUID userAccountId;

    @Column("professional_crm")
    private String professionalCrm;

    @Column("crm_state")
    private String crmState;

    @Column("desired_hourly_rate")
    private BigDecimal desiredHourlyRate;

    @Column("approval_status")
    private String approvalStatus;

    public java.util.UUID getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(java.util.UUID userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getProfessionalCrm() {
        return professionalCrm;
    }

    public void setProfessionalCrm(String professionalCrm) {
        this.professionalCrm = professionalCrm;
    }

    public String getCrmState() {
        return crmState;
    }

    public void setCrmState(String crmState) {
        this.crmState = crmState;
    }

    public BigDecimal getDesiredHourlyRate() {
        return desiredHourlyRate;
    }

    public void setDesiredHourlyRate(BigDecimal desiredHourlyRate) {
        this.desiredHourlyRate = desiredHourlyRate;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}
