package com.tws.company.service.auth;

import com.tws.company.config.Constants;
import com.tws.company.domain.Authority;
import com.tws.company.domain.DoctorProfile;
import com.tws.company.domain.HospitalProfile;
import com.tws.company.domain.User;
import com.tws.company.domain.UserAccount;
import com.tws.company.repository.HospitalProfileRepository;
import com.tws.company.repository.UserAccountRepository;
import com.tws.company.security.AuthoritiesConstants;
import com.tws.company.service.DoctorProfileService;
import com.tws.company.service.HospitalProfileService;
import com.tws.company.service.UserAccountService;
import com.tws.company.service.UserService;
import com.tws.company.service.auth.KeycloakAuthService.KeycloakTokenResponse;
import com.tws.company.service.dto.auth.AuthResponse;
import com.tws.company.service.dto.auth.LoginRequest;
import com.tws.company.service.dto.auth.RegisterDoctorRequest;
import com.tws.company.service.dto.auth.RegisterHospitalRequest;
import com.tws.company.service.dto.auth.RegisterUserRequest;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Service
public class AuthOrchestrationService {

    private static final String SYSTEM_USER = "system";
    private static final String DEFAULT_USER_STATUS = "ACTIVE";
    private static final String DEFAULT_DOCTOR_STATUS = "PENDING";
    private static final String DEFAULT_HOSPITAL_STATUS = "PENDING";
    private static final String DEFAULT_USER_DOC_STATUS = "APPROVED";
    private static final String DEFAULT_DOCTOR_DOC_STATUS = "PENDING";
    private static final String DEFAULT_HOSPITAL_DOC_STATUS = "PENDING";
    private static final String DEFAULT_DOCTOR_APPROVAL_STATUS = "PENDING";

    private final KeycloakAuthService keycloakAuthService;
    private final UserService userService;
    private final UserAccountService userAccountService;
    private final DoctorProfileService doctorProfileService;
    private final HospitalProfileService hospitalProfileService;
    private final UserAccountRepository userAccountRepository;
    private final HospitalProfileRepository hospitalProfileRepository;

    public AuthOrchestrationService(
        KeycloakAuthService keycloakAuthService,
        UserService userService,
        UserAccountService userAccountService,
        DoctorProfileService doctorProfileService,
        HospitalProfileService hospitalProfileService,
        UserAccountRepository userAccountRepository,
        HospitalProfileRepository hospitalProfileRepository
    ) {
        this.keycloakAuthService = keycloakAuthService;
        this.userService = userService;
        this.userAccountService = userAccountService;
        this.doctorProfileService = doctorProfileService;
        this.hospitalProfileService = hospitalProfileService;
        this.userAccountRepository = userAccountRepository;
        this.hospitalProfileRepository = hospitalProfileRepository;
    }

    public Mono<AuthResponse> login(LoginRequest request) {
        return keycloakAuthService.login(request.username(), request.password()).map(token -> toAuthResponse(token, null, null, null, null));
    }

    public Mono<AuthResponse> registerUser(RegisterUserRequest request) {
        String normalizedEmail = normalizeEmail(request.email());
        return ensureUserAccountEmailAvailable(normalizedEmail)
            .then(
                keycloakAuthService.createUser(normalizedEmail, normalizedEmail, request.password(), AuthoritiesConstants.USER).flatMap(keycloakUserId ->
                    createLocalUserAndUserAccount(
                        keycloakUserId,
                        normalizedEmail,
                        request.displayName(),
                        defaultIfBlank(request.userType(), "USER"),
                        defaultIfBlank(request.status(), DEFAULT_USER_STATUS),
                        defaultIfBlank(request.documentVerificationStatus(), DEFAULT_USER_DOC_STATUS),
                        request.activated() == null || request.activated(),
                        AuthoritiesConstants.USER
                    )
                        .flatMap(savedAccount ->
                            keycloakAuthService
                                .login(normalizedEmail, request.password())
                                .map(token -> toAuthResponse(token, keycloakUserId, savedAccount.getId(), null, null))
                        )
                        .onErrorResume(error -> rollbackKeycloakUser(keycloakUserId, error))
                )
            );
    }

    public Mono<AuthResponse> registerDoctor(RegisterDoctorRequest request) {
        String normalizedEmail = normalizeEmail(request.email());
        return ensureUserAccountEmailAvailable(normalizedEmail)
            .then(
                keycloakAuthService.createUser(normalizedEmail, normalizedEmail, request.password(), AuthoritiesConstants.DOCTOR).flatMap(keycloakUserId ->
                    createLocalUserAndUserAccount(
                        keycloakUserId,
                        normalizedEmail,
                        request.displayName(),
                        defaultIfBlank(request.userType(), "DOCTOR"),
                        defaultIfBlank(request.status(), DEFAULT_DOCTOR_STATUS),
                        defaultIfBlank(request.documentVerificationStatus(), DEFAULT_DOCTOR_DOC_STATUS),
                        request.activated() == null || request.activated(),
                        AuthoritiesConstants.USER,
                        AuthoritiesConstants.DOCTOR
                    )
                        .flatMap(savedAccount -> createDoctorProfile(request, savedAccount).flatMap(savedDoctor ->
                            keycloakAuthService
                                .login(normalizedEmail, request.password())
                                .map(token -> toAuthResponse(token, keycloakUserId, savedAccount.getId(), savedDoctor.getId(), null))
                        ))
                        .onErrorResume(error -> rollbackKeycloakUser(keycloakUserId, error))
                )
            );
    }

    public Mono<AuthResponse> registerHospital(RegisterHospitalRequest request) {
        String normalizedEmail = normalizeEmail(request.email());
        return ensureUserAccountEmailAvailable(normalizedEmail)
            .then(ensureHospitalCnpjAvailable(request.cnpj()))
            .then(
                keycloakAuthService.createUser(normalizedEmail, normalizedEmail, request.password(), AuthoritiesConstants.HOSPITAL).flatMap(
                    keycloakUserId ->
                        createLocalUserAndUserAccount(
                            keycloakUserId,
                            normalizedEmail,
                            request.displayName(),
                            defaultIfBlank(request.userType(), "HOSPITAL"),
                            defaultIfBlank(request.status(), DEFAULT_HOSPITAL_STATUS),
                            defaultIfBlank(request.documentVerificationStatus(), DEFAULT_HOSPITAL_DOC_STATUS),
                            request.activated() == null || request.activated(),
                            AuthoritiesConstants.USER,
                            AuthoritiesConstants.HOSPITAL
                        )
                            .flatMap(savedAccount -> createHospitalProfile(request, savedAccount).flatMap(savedHospital ->
                                keycloakAuthService
                                    .login(normalizedEmail, request.password())
                                    .map(token -> toAuthResponse(token, keycloakUserId, savedAccount.getId(), null, savedHospital.getId()))
                            ))
                            .onErrorResume(error -> rollbackKeycloakUser(keycloakUserId, error))
                )
            );
    }

    @Transactional
    Mono<UserAccount> createLocalUserAndUserAccount(
        String keycloakUserId,
        String email,
        String displayName,
        String userType,
        String status,
        String documentVerificationStatus,
        boolean activated,
        String... authorities
    ) {
        User user = buildUser(keycloakUserId, email, displayName, activated, Set.of(authorities));
        return userService.saveUser(user, true).flatMap(savedUser -> {
            UserAccount account = new UserAccount();
            account.setCreatedBy(SYSTEM_USER);
            account.setUserId(savedUser.getId());
            account.setKeycloakUserId(keycloakUserId);
            account.setEmail(email);
            account.setDisplayName(defaultIfBlank(displayName, email));
            account.setDisplayNameLowercase(resolveDisplayNameLowercase(displayName, email));
            account.setUserType(userType);
            account.setStatus(status);
            account.setDocumentVerificationStatus(documentVerificationStatus);
            account.setActivated(activated);
            return userAccountService.save(account);
        });
    }

    @Transactional
    Mono<DoctorProfile> createDoctorProfile(RegisterDoctorRequest request, UserAccount userAccount) {
        DoctorProfile doctorProfile = new DoctorProfile();
        doctorProfile.setCreatedBy(SYSTEM_USER);
        doctorProfile.setUserAccountId(userAccount.getId());
        doctorProfile.setProfessionalCrm(request.professionalCrm());
        doctorProfile.setCrmState(request.crmState());
        doctorProfile.setDesiredHourlyRate(request.desiredHourlyRate());
        doctorProfile.setApprovalStatus(defaultIfBlank(request.approvalStatus(), DEFAULT_DOCTOR_APPROVAL_STATUS));
        return doctorProfileService.save(doctorProfile);
    }

    @Transactional
    Mono<HospitalProfile> createHospitalProfile(RegisterHospitalRequest request, UserAccount userAccount) {
        HospitalProfile hospitalProfile = new HospitalProfile();
        hospitalProfile.setCreatedBy(SYSTEM_USER);
        hospitalProfile.setUserAccountId(userAccount.getId());
        hospitalProfile.setTradeName(request.tradeName());
        hospitalProfile.setLegalName(request.legalName());
        hospitalProfile.setCnpj(request.cnpj());
        hospitalProfile.setStateRegistration(request.stateRegistration());
        hospitalProfile.setPhone(request.phone());
        hospitalProfile.setAddress(request.address());
        hospitalProfile.setLegalRepresentativeName(request.legalRepresentativeName());
        hospitalProfile.setLegalRepresentativeCpf(request.legalRepresentativeCpf());
        hospitalProfile.setLegalRepresentativeEmail(request.legalRepresentativeEmail());
        return hospitalProfileService.save(hospitalProfile);
    }

    private Mono<Void> ensureUserAccountEmailAvailable(String email) {
        return userAccountRepository
            .findOneByEmail(email)
            .flatMap(existing -> Mono.error(new ResponseStatusException(HttpStatus.CONFLICT, "Email ja cadastrado em user_account")))
            .then();
    }

    private Mono<Void> ensureHospitalCnpjAvailable(String cnpj) {
        return hospitalProfileRepository
            .findOneByCnpj(cnpj)
            .flatMap(existing -> Mono.error(new ResponseStatusException(HttpStatus.CONFLICT, "CNPJ ja cadastrado para hospital")))
            .then();
    }

    private Mono<AuthResponse> rollbackKeycloakUser(String keycloakUserId, Throwable originalError) {
        return keycloakAuthService.deleteUser(keycloakUserId).onErrorResume(error -> Mono.empty()).then(Mono.error(originalError));
    }

    private static User buildUser(String keycloakUserId, String email, String displayName, boolean activated, Set<String> authorities) {
        User user = new User();
        user.setId(keycloakUserId);
        user.setLogin(email);
        user.setEmail(email);
        user.setActivated(activated);
        user.setLangKey(Constants.DEFAULT_LANGUAGE);
        user.setCreatedBy(SYSTEM_USER);
        user.setLastModifiedBy(SYSTEM_USER);

        if (displayName != null && !displayName.isBlank()) {
            String[] names = displayName.trim().split("\\s+", 2);
            user.setFirstName(names[0]);
            if (names.length > 1) {
                user.setLastName(names[1]);
            }
        }

        LinkedHashSet<Authority> authoritySet = new LinkedHashSet<>();
        for (String authorityName : authorities) {
            Authority authority = new Authority();
            authority.setName(authorityName);
            authoritySet.add(authority);
        }
        user.setAuthorities(authoritySet);
        return user;
    }

    private static AuthResponse toAuthResponse(
        KeycloakTokenResponse token,
        String keycloakUserId,
        java.util.UUID userAccountId,
        java.util.UUID doctorProfileId,
        java.util.UUID hospitalProfileId
    ) {
        return new AuthResponse(
            token.accessToken(),
            token.refreshToken(),
            token.tokenType(),
            token.expiresIn(),
            token.refreshExpiresIn(),
            token.scope(),
            keycloakUserId,
            userAccountId,
            doctorProfileId,
            hospitalProfileId
        );
    }

    private static String normalizeEmail(String email) {
        return email.trim().toLowerCase(Locale.ROOT);
    }

    private static String defaultIfBlank(String value, String fallback) {
        return value == null || value.isBlank() ? fallback : value;
    }

    private static String resolveDisplayNameLowercase(String displayName, String email) {
        return defaultIfBlank(displayName, email).toLowerCase(Locale.ROOT);
    }
}
