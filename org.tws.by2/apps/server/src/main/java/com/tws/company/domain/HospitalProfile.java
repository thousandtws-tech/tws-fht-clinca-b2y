package com.tws.company.domain;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("hospital_profile")
public class HospitalProfile extends AbstractAuditingUuidEntity {

    @Column("user_account_id")
    private java.util.UUID userAccountId;

    @Column("trade_name")
    private String tradeName;

    @Column("legal_name")
    private String legalName;

    @Column("cnpj")
    private String cnpj;

    @Column("state_registration")
    private String stateRegistration;

    @Column("phone")
    private String phone;

    @Column("address")
    private String address;

    @Column("legal_representative_name")
    private String legalRepresentativeName;

    @Column("legal_representative_cpf")
    private String legalRepresentativeCpf;

    @Column("legal_representative_email")
    private String legalRepresentativeEmail;

    public java.util.UUID getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(java.util.UUID userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getStateRegistration() {
        return stateRegistration;
    }

    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLegalRepresentativeName() {
        return legalRepresentativeName;
    }

    public void setLegalRepresentativeName(String legalRepresentativeName) {
        this.legalRepresentativeName = legalRepresentativeName;
    }

    public String getLegalRepresentativeCpf() {
        return legalRepresentativeCpf;
    }

    public void setLegalRepresentativeCpf(String legalRepresentativeCpf) {
        this.legalRepresentativeCpf = legalRepresentativeCpf;
    }

    public String getLegalRepresentativeEmail() {
        return legalRepresentativeEmail;
    }

    public void setLegalRepresentativeEmail(String legalRepresentativeEmail) {
        this.legalRepresentativeEmail = legalRepresentativeEmail;
    }
}
