package com.tws.company.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("doctor_time_slot")
public class DoctorTimeSlot extends AbstractAuditingUuidEntity {

    @Column("doctor_profile_id")
    private UUID doctorProfileId;

    @Column("doctor_name")
    private String doctorName;

    @Column("slot_date")
    private LocalDate slotDate;

    @Column("start_time")
    private LocalTime startTime;

    @Column("end_time")
    private LocalTime endTime;

    @Column("is_overnight")
    private boolean overnight;

    @Column("service_type")
    private String serviceType;

    @Column("desired_hourly_rate")
    private BigDecimal desiredHourlyRate;

    @Column("status")
    private String status;

    @Column("notes")
    private String notes;

    @Column("state")
    private String state;

    public UUID getDoctorProfileId() {
        return doctorProfileId;
    }

    public void setDoctorProfileId(UUID doctorProfileId) {
        this.doctorProfileId = doctorProfileId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public LocalDate getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(LocalDate slotDate) {
        this.slotDate = slotDate;
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

    public BigDecimal getDesiredHourlyRate() {
        return desiredHourlyRate;
    }

    public void setDesiredHourlyRate(BigDecimal desiredHourlyRate) {
        this.desiredHourlyRate = desiredHourlyRate;
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
