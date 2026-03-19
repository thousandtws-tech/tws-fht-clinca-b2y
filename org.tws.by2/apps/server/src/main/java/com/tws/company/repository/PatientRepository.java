package com.tws.company.repository;

import com.tws.company.domain.Patient;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PatientRepository extends R2dbcRepository<Patient, UUID> {
    Mono<Patient> findOneByCpf(String cpf);
}
