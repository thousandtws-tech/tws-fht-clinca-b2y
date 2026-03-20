package com.tws.company.domain;

import java.util.UUID;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("prescription")
public class Prescription extends AbstractAuditingUuidEntity {

    @Column("consultation_id")
    private UUID consultationId;

    @Column("patient_name")
    private String patientName;

    @Column("doctor_name")
    private String doctorName;

    @Column("doctor_crm")
    private String doctorCrm;

    @Column("pdf_path")
    private String pdfPath;

    public UUID getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(UUID consultationId) {
        this.consultationId = consultationId;
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

    public String getDoctorCrm() {
        return doctorCrm;
    }

    public void setDoctorCrm(String doctorCrm) {
        this.doctorCrm = doctorCrm;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }
}
