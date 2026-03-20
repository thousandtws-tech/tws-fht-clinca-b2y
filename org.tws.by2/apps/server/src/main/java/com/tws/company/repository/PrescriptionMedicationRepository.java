package com.tws.company.repository;

import com.tws.company.domain.PrescriptionMedication;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionMedicationRepository extends R2dbcRepository<PrescriptionMedication, UUID> {}
