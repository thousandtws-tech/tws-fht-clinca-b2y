package com.tws.company.service;

import com.tws.company.domain.DoctorProfile;
import com.tws.company.domain.HealthUnitDoctorLink;
import com.tws.company.domain.enums.DoctorApprovalStatus;
import com.tws.company.domain.enums.DocumentVerificationStatus;
import com.tws.company.domain.enums.HealthUnitDoctorLinkType;
import com.tws.company.domain.enums.UserStatus;
import com.tws.company.repository.DoctorProfileRepository;
import com.tws.company.repository.HealthUnitDoctorLinkRepository;
import com.tws.company.repository.UserAccountRepository;
import com.tws.company.service.dto.AssociatedDoctorResponse;
import com.tws.company.service.dto.SearchAssociatedDoctorsRequest;
import com.tws.company.service.mapper.EnumMapper;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.r2dbc.core.DatabaseClient.GenericExecuteSpec;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DoctorAssociationWorkflowService {

    private final HealthUnitDoctorLinkRepository healthUnitDoctorLinkRepository;
    private final DoctorProfileRepository doctorProfileRepository;
    private final UserAccountRepository userAccountRepository;
    private final DatabaseClient databaseClient;

    public DoctorAssociationWorkflowService(
        HealthUnitDoctorLinkRepository healthUnitDoctorLinkRepository,
        DoctorProfileRepository doctorProfileRepository,
        UserAccountRepository userAccountRepository,
        DatabaseClient databaseClient
    ) {
        this.healthUnitDoctorLinkRepository = healthUnitDoctorLinkRepository;
        this.doctorProfileRepository = doctorProfileRepository;
        this.userAccountRepository = userAccountRepository;
        this.databaseClient = databaseClient;
    }

    @Transactional
    public Mono<HealthUnitDoctorLink> associateDoctorToHospital(UUID hospitalProfileId, UUID doctorProfileId) {
        return healthUnitDoctorLinkRepository
            .existsByHospitalProfileIdAndDoctorProfileId(hospitalProfileId, doctorProfileId)
            .flatMap(exists -> {
                if (exists) {
                    return healthUnitDoctorLinkRepository
                        .findAllByHospitalProfileId(hospitalProfileId)
                        .filter(link -> doctorProfileId.equals(link.getDoctorProfileId()))
                        .next();
                }
                HealthUnitDoctorLink link = new HealthUnitDoctorLink();
                link.setId(UUID.randomUUID());
                link.setHospitalProfileId(hospitalProfileId);
                link.setDoctorProfileId(doctorProfileId);
                link.setLinkType(EnumMapper.toValue(HealthUnitDoctorLinkType.MANUAL));
                link.setCreatedBy("system");
                link.setLastModifiedBy("system");
                return healthUnitDoctorLinkRepository.save(link);
            });
    }

    @Transactional(readOnly = true)
    public Flux<AssociatedDoctorResponse> searchAssociatedDoctors(SearchAssociatedDoctorsRequest request) {
        String normalizedSearchTerm = request.searchTerm() == null ? null : "%" + request.searchTerm().toLowerCase(Locale.ROOT) + "%";

        GenericExecuteSpec sql = databaseClient.sql(
            """
            SELECT DISTINCT dp.id AS doctor_profile_id, ua.id AS user_account_id, ua.display_name, dp.professional_crm, ua.email
            FROM health_unit_doctor_link hudl
            JOIN doctor_profile dp ON dp.id = hudl.doctor_profile_id
            JOIN user_account ua ON ua.id = dp.user_account_id
            WHERE hudl.hospital_profile_id = :hospitalProfileId
            """
        ).bind("hospitalProfileId", request.hospitalProfileId());

        Flux<AssociatedDoctorResponse> base = sql
            .map(
                (row, metadata) ->
                    new AssociatedDoctorResponse(
                        row.get("doctor_profile_id", UUID.class),
                        row.get("user_account_id", UUID.class),
                        row.get("display_name", String.class),
                        row.get("professional_crm", String.class),
                        row.get("email", String.class),
                        List.of()
                    )
            )
            .all();

        return base
            .filterWhen(doctor -> filterDoctor(doctor, normalizedSearchTerm, request.specialties()))
            .flatMap(doctor ->
                loadSpecialties(doctor.doctorProfileId()).collectList().map(specialties ->
                    new AssociatedDoctorResponse(
                        doctor.doctorProfileId(),
                        doctor.userAccountId(),
                        doctor.name(),
                        doctor.crm(),
                        doctor.email(),
                        specialties
                    )
                )
            );
    }

    @Transactional
    public Mono<DoctorProfile> approveDoctor(UUID doctorProfileId) {
        return doctorProfileRepository
            .findById(doctorProfileId)
            .flatMap(doctorProfile ->
                userAccountRepository
                    .findById(doctorProfile.getUserAccountId())
                    .flatMap(userAccount -> {
                        doctorProfile.setApprovalStatus(EnumMapper.toValue(DoctorApprovalStatus.APPROVED));
                        userAccount.setStatus(EnumMapper.toValue(UserStatus.ACTIVE));
                        userAccount.setDocumentVerificationStatus(EnumMapper.toValue(DocumentVerificationStatus.APPROVED));
                        return doctorProfileRepository.save(doctorProfile).then(userAccountRepository.save(userAccount)).thenReturn(doctorProfile);
                    })
            );
    }

    private Mono<Boolean> filterDoctor(AssociatedDoctorResponse doctor, String normalizedSearchTerm, List<String> specialties) {
        Mono<Boolean> searchMatches = Mono.just(
            normalizedSearchTerm == null ||
            containsIgnoreCase(doctor.name(), normalizedSearchTerm) ||
            containsIgnoreCase(doctor.crm(), normalizedSearchTerm) ||
            containsIgnoreCase(doctor.email(), normalizedSearchTerm)
        );

        Mono<Boolean> specialtyMatches = loadSpecialties(doctor.doctorProfileId())
            .collectList()
            .map(doctorSpecialties ->
                specialties == null ||
                specialties.isEmpty() ||
                doctorSpecialties.stream().map(value -> value.toLowerCase(Locale.ROOT)).anyMatch(specialty ->
                    specialties.stream().map(value -> value.toLowerCase(Locale.ROOT)).anyMatch(specialty::equals)
                )
            );

        return Mono.zip(searchMatches, specialtyMatches).map(tuple -> tuple.getT1() && tuple.getT2());
    }

    private Flux<String> loadSpecialties(UUID doctorProfileId) {
        return databaseClient
            .sql("SELECT specialty FROM doctor_profile_specialty WHERE doctor_profile_id = :doctorProfileId ORDER BY specialty")
            .bind("doctorProfileId", doctorProfileId)
            .map((row, metadata) -> row.get("specialty", String.class))
            .all();
    }

    private boolean containsIgnoreCase(String value, String normalizedPattern) {
        if (value == null) {
            return false;
        }
        return value.toLowerCase(Locale.ROOT).contains(normalizedPattern.replace("%", ""));
    }
}
