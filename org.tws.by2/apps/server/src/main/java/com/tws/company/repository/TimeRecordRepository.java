package com.tws.company.repository;

import com.tws.company.domain.TimeRecord;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRecordRepository extends R2dbcRepository<TimeRecord, UUID> {}
