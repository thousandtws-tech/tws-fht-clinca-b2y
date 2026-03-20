package com.tws.company.domain;

import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;

public abstract class AbstractAuditingUuidEntity extends AbstractAuditingEntity<UUID> implements Persistable<UUID> {

    @Id
    @Column("id")
    private UUID id;

    @Transient
    private boolean isPersisted;

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean isNew() {
        return !isPersisted;
    }

    public AbstractAuditingUuidEntity setIsPersisted() {
        this.isPersisted = true;
        return this;
    }
}
