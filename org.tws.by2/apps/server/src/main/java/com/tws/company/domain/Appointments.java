package com.tws.company.domain;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.relational.core.mapping.Column;

public class Appointments {

    @Id
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Keyword)
    @Column("id")
    private String id;

    @Column("patient_id")
    private String patientId;

    @Column("patient_name")
    private String patientName;

    @Column("doctor_id")
    private String doctorId;

    @Column("doctor_name")
    private String doctorName;

    private List<String> specialty;

    @Column("appointment_type")
    private String type;

    @Column("appointment_date")
    private LocalDate appointmentDate;

    @Column("status")
    private String status;

    @Column("telemedicine_room_url")
    private String telemedicineRoomUrl;

    @Column("ai_analysis_report")
    private String aiAnalysisReport;

    @Column("created_by")
    private String createdBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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

    public List<String> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(List<String> specialty) {
        this.specialty = specialty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
