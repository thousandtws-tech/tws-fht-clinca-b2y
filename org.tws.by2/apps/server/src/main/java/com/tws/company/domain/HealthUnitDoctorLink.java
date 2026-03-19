package com.tws.company.domain;

import java.util.UUID;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("health_unit_doctor_link")
public class HealthUnitDoctorLink extends AbstractAuditingUuidEntity {

    @Column("hospital_profile_id")
    private UUID hospitalProfileId;

    @Column("doctor_profile_id")
    private UUID doctorProfileId;

    @Column("link_type")
    private String linkType;

    public UUID getHospitalProfileId() {
        return hospitalProfileId;
    }

    public void setHospitalProfileId(UUID hospitalProfileId) {
        this.hospitalProfileId = hospitalProfileId;
    }

    public UUID getDoctorProfileId() {
        return doctorProfileId;
    }

    public void setDoctorProfileId(UUID doctorProfileId) {
        this.doctorProfileId = doctorProfileId;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }
}
