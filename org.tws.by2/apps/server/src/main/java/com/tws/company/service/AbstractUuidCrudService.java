package com.tws.company.service;

import com.tws.company.domain.AbstractAuditingUuidEntity;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class AbstractUuidCrudService<T extends AbstractAuditingUuidEntity> {

    private final R2dbcRepository<T, UUID> repository;

    protected AbstractUuidCrudService(R2dbcRepository<T, UUID> repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Flux<T> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Mono<T> findById(UUID id) {
        return repository.findById(id);
    }

    @Transactional
    public Mono<T> save(T entity) {
        return repository.save(entity);
    }

    @Transactional
    public Mono<Void> deleteById(UUID id) {
        return repository.deleteById(id);
    }
}
