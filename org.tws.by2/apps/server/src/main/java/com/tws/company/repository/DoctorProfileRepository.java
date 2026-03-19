package com.tws.company.repository;

import com.tws.company.domain.DoctorProfile;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface DoctorProfileRepository extends R2dbcRepository<DoctorProfile, UUID> {
    Mono<DoctorProfile> findOneByUserAccountId(UUID userAccountId);
}
