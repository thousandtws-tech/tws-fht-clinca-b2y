package com.tws.company.repository;

import com.tws.company.domain.UserAccount;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserAccountRepository extends R2dbcRepository<UserAccount, UUID> {
    Mono<UserAccount> findOneByEmail(String email);
}
