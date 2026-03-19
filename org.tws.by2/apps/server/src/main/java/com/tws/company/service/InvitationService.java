package com.tws.company.service;

import com.tws.company.domain.Invitation;
import com.tws.company.repository.InvitationRepository;
import org.springframework.stereotype.Service;

@Service
public class InvitationService extends AbstractUuidCrudService<Invitation> {

    public InvitationService(InvitationRepository repository) {
        super(repository);
    }
}
