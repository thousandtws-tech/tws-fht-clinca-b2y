package com.tws.company.repository;

import com.tws.company.domain.Consultation;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends R2dbcRepository<Consultation, UUID> {}
