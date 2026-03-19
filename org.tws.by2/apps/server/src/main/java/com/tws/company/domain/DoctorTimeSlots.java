package com.tws.company.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.relational.core.mapping.Column;

public class DoctorTimeSlots {

    @Id
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Keyword)
    @Column("id")
    private String id;

    @Column("doctor_id")
    private String doctorId;

    @Column("doctor_name")
    private String doctorName;

    @Column("date")
    private LocalDate date;

    @Column("start_time")
    private LocalTime startTime;

    @Column("end_time")
    private LocalTime endTime;

    @Column("is_overnight")
    private Boolean isOvernight;

    @Column("service_type")
    private String serviceType;

    private List<String> specialties;

    @Column("desired_hourly_rate")
    private BigDecimal desiredHourlyRate;

    @Column("status")
    private String status;

    @Column("notes")
    private String notes;

    private List<String> cities;

    @Column("state")
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public Boolean getIsOvernight() {
        return isOvernight;
    }

    public void setIsOvernight(Boolean isOvernight) {
        this.isOvernight = isOvernight;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<String> specialties) {
        this.specialties = specialties;
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

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
