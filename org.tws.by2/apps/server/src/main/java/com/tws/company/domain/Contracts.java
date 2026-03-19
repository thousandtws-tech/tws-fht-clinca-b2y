package com.tws.company.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.relational.core.mapping.Column;

public class Contracts {

    @Id
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Keyword)
    @Column("id")
    private String id;

    @Column("shift_requirement_id")
    private String shiftRequirementId;

    @Column("doctor_id")
    private String doctorId;

    @Column("hospital_id")
    private String hospitalId;

    @Column("doctor_name")
    private String doctorName;

    @Column("hospital_name")
    private String hospitalName;

    private List<String> specialties;

    private List<LocalDate> shiftDates;

    @Column("start_time")
    private LocalTime startTime;

    @Column("end_time")
    private LocalTime endTime;

    @Column("doctor_rate")
    private BigDecimal doctorRate;

    @Column("service_type")
    private String serviceType;

    @Column("status")
    private String status;

    @Column("contract_pdf_path")
    private String contractPdfPath;

    @Column("telemedicine_link")
    private String telemedicineLink;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShiftRequirementId() {
        return shiftRequirementId;
    }

    public void setShiftRequirementId(String shiftRequirementId) {
        this.shiftRequirementId = shiftRequirementId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<String> specialties) {
        this.specialties = specialties;
    }

    public List<LocalDate> getShiftDates() {
        return shiftDates;
    }

    public void setShiftDates(List<LocalDate> shiftDates) {
        this.shiftDates = shiftDates;
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

    public BigDecimal getDoctorRate() {
        return doctorRate;
    }

    public void setDoctorRate(BigDecimal doctorRate) {
        this.doctorRate = doctorRate;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContractPdfPath() {
        return contractPdfPath;
    }

    public void setContractPdfPath(String contractPdfPath) {
        this.contractPdfPath = contractPdfPath;
    }

    public String getTelemedicineLink() {
        return telemedicineLink;
    }

    public void setTelemedicineLink(String telemedicineLink) {
        this.telemedicineLink = telemedicineLink;
    }
}
