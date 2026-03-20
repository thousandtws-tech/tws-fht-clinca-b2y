package com.tws.company.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Server.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 * See {@link tech.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private final Security security = new Security();

    public Security getSecurity() {
        return security;
    }

    public static class Security {

        private final Keycloak keycloak = new Keycloak();

        public Keycloak getKeycloak() {
            return keycloak;
        }
    }

    public static class Keycloak {

        private String realm;
        private String adminClientId;
        private String adminClientSecret;

        public String getRealm() {
            return realm;
        }

        public void setRealm(String realm) {
            this.realm = realm;
        }

        public String getAdminClientId() {
            return adminClientId;
        }

        public void setAdminClientId(String adminClientId) {
            this.adminClientId = adminClientId;
        }

        public String getAdminClientSecret() {
            return adminClientSecret;
        }

        public void setAdminClientSecret(String adminClientSecret) {
            this.adminClientSecret = adminClientSecret;
        }
    }

    // jhipster-needle-application-properties-property
    // jhipster-needle-application-properties-property-getter
    // jhipster-needle-application-properties-property-class
}
