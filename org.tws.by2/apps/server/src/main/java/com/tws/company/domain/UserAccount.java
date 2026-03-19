package com.tws.company.domain;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("user_account")
public class UserAccount extends AbstractAuditingUuidEntity {

    @Column("user_id")
    private String userId;

    @Column("keycloak_user_id")
    private String keycloakUserId;

    @Column("email")
    private String email;

    @Column("display_name")
    private String displayName;

    @Column("display_name_lowercase")
    private String displayNameLowercase;

    @Column("user_type")
    private String userType;

    @Column("status")
    private String status;

    @Column("document_verification_status")
    private String documentVerificationStatus;

    @Column("activated")
    private boolean activated;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getKeycloakUserId() {
        return keycloakUserId;
    }

    public void setKeycloakUserId(String keycloakUserId) {
        this.keycloakUserId = keycloakUserId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayNameLowercase() {
        return displayNameLowercase;
    }

    public void setDisplayNameLowercase(String displayNameLowercase) {
        this.displayNameLowercase = displayNameLowercase;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDocumentVerificationStatus() {
        return documentVerificationStatus;
    }

    public void setDocumentVerificationStatus(String documentVerificationStatus) {
        this.documentVerificationStatus = documentVerificationStatus;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
