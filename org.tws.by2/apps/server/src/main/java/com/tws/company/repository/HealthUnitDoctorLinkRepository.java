package com.tws.company.repository;

import com.tws.company.domain.HealthUnitDoctorLink;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface HealthUnitDoctorLinkRepository extends R2dbcRepository<HealthUnitDoctorLink, UUID> {
    Flux<HealthUnitDoctorLink> findAllByHospitalProfileId(UUID hospitalProfileId);

    Mono<Boolean> existsByHospitalProfileIdAndDoctorProfileId(UUID hospitalProfileId, UUID doctorProfileId);
}
