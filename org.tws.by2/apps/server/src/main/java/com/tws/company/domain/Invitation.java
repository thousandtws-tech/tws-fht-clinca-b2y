package com.tws.company.domain;

import java.time.Instant;
import java.util.UUID;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("invitation")
public class Invitation extends AbstractAuditingUuidEntity {

    @Column("hospital_profile_id")
    private UUID hospitalProfileId;

    @Column("email")
    private String email;

    @Column("token")
    private String token;

    @Column("status")
    private String status;

    @Column("expires_at")
    private Instant expiresAt;

    public UUID getHospitalProfileId() {
        return hospitalProfileId;
    }

    public void setHospitalProfileId(UUID hospitalProfileId) {
        this.hospitalProfileId = hospitalProfileId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Instant expiresAt) {
        this.expiresAt = expiresAt;
    }
}
