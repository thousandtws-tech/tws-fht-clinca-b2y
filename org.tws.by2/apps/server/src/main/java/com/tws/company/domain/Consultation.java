package com.tws.company.domain;

import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("consultation")
public class Consultation extends AbstractAuditingUuidEntity {

    @Column("appointment_id")
    private UUID appointmentId;

    @Column("patient_id")
    private UUID patientId;

    @Column("doctor_profile_id")
    private UUID doctorProfileId;

    @Column("telemedicine_link")
    private String telemedicineLink;

    @Column("status")
    private String status;

    @Column("total_material_cost")
    private BigDecimal totalMaterialCost;

    public UUID getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(UUID appointmentId) {
        this.appointmentId = appointmentId;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public UUID getDoctorProfileId() {
        return doctorProfileId;
    }

    public void setDoctorProfileId(UUID doctorProfileId) {
        this.doctorProfileId = doctorProfileId;
    }

    public String getTelemedicineLink() {
        return telemedicineLink;
    }

    public void setTelemedicineLink(String telemedicineLink) {
        this.telemedicineLink = telemedicineLink;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalMaterialCost() {
        return totalMaterialCost;
    }

    public void setTotalMaterialCost(BigDecimal totalMaterialCost) {
        this.totalMaterialCost = totalMaterialCost;
    }
}
