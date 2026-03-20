package com.tws.company.repository;

import com.tws.company.domain.HospitalProfile;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface HospitalProfileRepository extends R2dbcRepository<HospitalProfile, UUID> {
    Mono<HospitalProfile> findOneByUserAccountId(UUID userAccountId);

    Mono<HospitalProfile> findOneByCnpj(String cnpj);
}
