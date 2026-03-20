package com.tws.company.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("time_record")
public class TimeRecord extends AbstractAuditingUuidEntity {

    @Column("contract_id")
    private UUID contractId;

    @Column("doctor_profile_id")
    private UUID doctorProfileId;

    @Column("hospital_profile_id")
    private UUID hospitalProfileId;

    @Column("check_in_time")
    private Instant checkInTime;

    @Column("check_in_latitude")
    private BigDecimal checkInLatitude;

    @Column("check_in_longitude")
    private BigDecimal checkInLongitude;

    @Column("check_in_photo_path")
    private String checkInPhotoPath;

    @Column("check_out_time")
    private Instant checkOutTime;

    @Column("check_out_latitude")
    private BigDecimal checkOutLatitude;

    @Column("check_out_longitude")
    private BigDecimal checkOutLongitude;

    @Column("check_out_photo_path")
    private String checkOutPhotoPath;

    @Column("status")
    private String status;

    public UUID getContractId() {
        return contractId;
    }

    public void setContractId(UUID contractId) {
        this.contractId = contractId;
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

    public Instant getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Instant checkInTime) {
        this.checkInTime = checkInTime;
    }

    public BigDecimal getCheckInLatitude() {
        return checkInLatitude;
    }

    public void setCheckInLatitude(BigDecimal checkInLatitude) {
        this.checkInLatitude = checkInLatitude;
    }

    public BigDecimal getCheckInLongitude() {
        return checkInLongitude;
    }

    public void setCheckInLongitude(BigDecimal checkInLongitude) {
        this.checkInLongitude = checkInLongitude;
    }

    public String getCheckInPhotoPath() {
        return checkInPhotoPath;
    }

    public void setCheckInPhotoPath(String checkInPhotoPath) {
        this.checkInPhotoPath = checkInPhotoPath;
    }

    public Instant getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Instant checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public BigDecimal getCheckOutLatitude() {
        return checkOutLatitude;
    }

    public void setCheckOutLatitude(BigDecimal checkOutLatitude) {
        this.checkOutLatitude = checkOutLatitude;
    }

    public BigDecimal getCheckOutLongitude() {
        return checkOutLongitude;
    }

    public void setCheckOutLongitude(BigDecimal checkOutLongitude) {
        this.checkOutLongitude = checkOutLongitude;
    }

    public String getCheckOutPhotoPath() {
        return checkOutPhotoPath;
    }

    public void setCheckOutPhotoPath(String checkOutPhotoPath) {
        this.checkOutPhotoPath = checkOutPhotoPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
