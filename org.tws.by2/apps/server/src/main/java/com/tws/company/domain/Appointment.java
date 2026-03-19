package com.tws.company.domain;

import java.time.Instant;
import java.util.UUID;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("appointment")
public class Appointment extends AbstractAuditingUuidEntity {

    @Column("patient_id")
    private UUID patientId;

    @Column("doctor_profile_id")
    private UUID doctorProfileId;

    @Column("created_by_user_account_id")
    private UUID createdByUserAccountId;

    @Column("patient_name")
    private String patientName;

    @Column("doctor_name")
    private String doctorName;

    @Column("specialty")
    private String specialty;

    @Column("appointment_type")
    private String appointmentType;

    @Column("status")
    private String status;

    @Column("appointment_date")
    private Instant appointmentDate;

    @Column("telemedicine_room_url")
    private String telemedicineRoomUrl;

    @Column("ai_analysis_report")
    private String aiAnalysisReport;

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

    public UUID getCreatedByUserAccountId() {
        return createdByUserAccountId;
    }

    public void setCreatedByUserAccountId(UUID createdByUserAccountId) {
        this.createdByUserAccountId = createdByUserAccountId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Instant appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getTelemedicineRoomUrl() {
        return telemedicineRoomUrl;
    }

    public void setTelemedicineRoomUrl(String telemedicineRoomUrl) {
        this.telemedicineRoomUrl = telemedicineRoomUrl;
    }

    public String getAiAnalysisReport() {
        return aiAnalysisReport;
    }

    public void setAiAnalysisReport(String aiAnalysisReport) {
        this.aiAnalysisReport = aiAnalysisReport;
    }
}
