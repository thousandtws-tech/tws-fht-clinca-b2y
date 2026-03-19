package com.tws.company.domain;

import java.util.UUID;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("clinical_document")
public class ClinicalDocument extends AbstractAuditingUuidEntity {

    @Column("consultation_id")
    private UUID consultationId;

    @Column("document_type")
    private String documentType;

    @Column("patient_name")
    private String patientName;

    @Column("doctor_name")
    private String doctorName;

    @Column("doctor_crm")
    private String doctorCrm;

    @Column("days_off")
    private Integer daysOff;

    @Column("cid")
    private String cid;

    @Column("consultation_period")
    private String consultationPeriod;

    @Column("pdf_path")
    private String pdfPath;

    public UUID getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(UUID consultationId) {
        this.consultationId = consultationId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
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

    public Integer getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(Integer daysOff) {
        this.daysOff = daysOff;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getConsultationPeriod() {
        return consultationPeriod;
    }

    public void setConsultationPeriod(String consultationPeriod) {
        this.consultationPeriod = consultationPeriod;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }
}
