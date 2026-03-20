package com.tws.company.repository;

import com.tws.company.domain.ClinicalDocument;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicalDocumentRepository extends R2dbcRepository<ClinicalDocument, UUID> {}
