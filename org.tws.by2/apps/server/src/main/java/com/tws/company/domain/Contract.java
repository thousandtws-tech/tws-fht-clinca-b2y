package com.tws.company.domain;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.UUID;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("contract")
public class Contract extends AbstractAuditingUuidEntity {

    @Column("shift_requirement_id")
    private UUID shiftRequirementId;

    @Column("doctor_profile_id")
    private UUID doctorProfileId;

    @Column("hospital_profile_id")
    private UUID hospitalProfileId;

    @Column("doctor_name")
    private String doctorName;

    @Column("hospital_name")
    private String hospitalName;

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

    public UUID getShiftRequirementId() {
        return shiftRequirementId;
    }

    public void setShiftRequirementId(UUID shiftRequirementId) {
        this.shiftRequirementId = shiftRequirementId;
    }

    public UUID getDoctorProfileId() {
        return doctorProfileId;
    }

    public void setDoctorProfileId(UUID doctorProfileId) {
        this.doctorProfileId = doctorProfileId;
    }

    public UUID getHospitalProfileId() {
        return hospitalProfileId;
    }

    public void setHospitalProfileId(UUID hospitalProfileId) {
        this.hospitalProfileId = hospitalProfileId;
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
