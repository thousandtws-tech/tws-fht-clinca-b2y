package com.tws.company.domain;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.UUID;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("shift_requirement")
public class ShiftRequirement extends AbstractAuditingUuidEntity {

    @Column("hospital_profile_id")
    private UUID hospitalProfileId;

    @Column("hospital_name")
    private String hospitalName;

    @Column("start_time")
    private LocalTime startTime;

    @Column("end_time")
    private LocalTime endTime;

    @Column("is_overnight")
    private boolean overnight;

    @Column("service_type")
    private String serviceType;

    @Column("offered_rate")
    private BigDecimal offeredRate;

    @Column("number_of_vacancies")
    private Integer numberOfVacancies;

    @Column("status")
    private String status;

    @Column("notes")
    private String notes;

    @Column("state")
    private String state;

    public UUID getHospitalProfileId() {
        return hospitalProfileId;
    }

    public void setHospitalProfileId(UUID hospitalProfileId) {
        this.hospitalProfileId = hospitalProfileId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public boolean isOvernight() {
        return overnight;
    }

    public void setOvernight(boolean overnight) {
        this.overnight = overnight;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public BigDecimal getOfferedRate() {
        return offeredRate;
    }

    public void setOfferedRate(BigDecimal offeredRate) {
        this.offeredRate = offeredRate;
    }

    public Integer getNumberOfVacancies() {
        return numberOfVacancies;
    }

    public void setNumberOfVacancies(Integer numberOfVacancies) {
        this.numberOfVacancies = numberOfVacancies;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
