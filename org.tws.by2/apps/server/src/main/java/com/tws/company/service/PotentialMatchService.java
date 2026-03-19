package com.tws.company.service;

import com.tws.company.domain.PotentialMatch;
import com.tws.company.repository.PotentialMatchRepository;
import org.springframework.stereotype.Service;

@Service
public class PotentialMatchService extends AbstractUuidCrudService<PotentialMatch> {

    public PotentialMatchService(PotentialMatchRepository repository) {
        super(repository);
    }
}
