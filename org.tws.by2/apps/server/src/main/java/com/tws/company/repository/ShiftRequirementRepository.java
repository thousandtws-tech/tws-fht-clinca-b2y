package com.tws.company.repository;

import com.tws.company.domain.ShiftRequirement;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRequirementRepository extends R2dbcRepository<ShiftRequirement, UUID> {}
