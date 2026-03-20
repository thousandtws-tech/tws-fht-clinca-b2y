package com.tws.company.repository;

import com.tws.company.domain.PotentialMatch;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotentialMatchRepository extends R2dbcRepository<PotentialMatch, UUID> {}
