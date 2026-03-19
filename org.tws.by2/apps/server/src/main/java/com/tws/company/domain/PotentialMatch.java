package com.tws.company.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("potential_match")
public class PotentialMatch extends AbstractAuditingUuidEntity {

    @Column("shift_requirement_id")
    private UUID shiftRequirementId;

    @Column("doctor_time_slot_id")
    private UUID doctorTimeSlotId;

    @Column("doctor_profile_id")
    private UUID doctorProfileId;

    @Column("hospital_profile_id")
    private UUID hospitalProfileId;

    @Column("matched_date")
    private LocalDate matchedDate;

    @Column("match_score")
    private Integer matchScore;

    @Column("status")
    private String status;

    @Column("offered_rate_by_hospital")
    private BigDecimal offeredRateByHospital;

    @Column("doctor_desired_rate")
    private BigDecimal doctorDesiredRate;

    public UUID getShiftRequirementId() {
        return shiftRequirementId;
    }

    public void setShiftRequirementId(UUID shiftRequirementId) {
        this.shiftRequirementId = shiftRequirementId;
    }

    public UUID getDoctorTimeSlotId() {
        return doctorTimeSlotId;
    }

    public void setDoctorTimeSlotId(UUID doctorTimeSlotId) {
        this.doctorTimeSlotId = doctorTimeSlotId;
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

    public LocalDate getMatchedDate() {
        return matchedDate;
    }

    public void setMatchedDate(LocalDate matchedDate) {
        this.matchedDate = matchedDate;
    }

    public Integer getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(Integer matchScore) {
        this.matchScore = matchScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getOfferedRateByHospital() {
        return offeredRateByHospital;
    }

    public void setOfferedRateByHospital(BigDecimal offeredRateByHospital) {
        this.offeredRateByHospital = offeredRateByHospital;
    }

    public BigDecimal getDoctorDesiredRate() {
        return doctorDesiredRate;
    }

    public void setDoctorDesiredRate(BigDecimal doctorDesiredRate) {
        this.doctorDesiredRate = doctorDesiredRate;
    }
}
