package com.tws.company.repository;

import com.tws.company.domain.BillingItem;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingItemRepository extends R2dbcRepository<BillingItem, UUID> {}
