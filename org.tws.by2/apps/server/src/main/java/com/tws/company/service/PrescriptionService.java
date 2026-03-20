package com.tws.company.service;

import com.tws.company.domain.Prescription;
import com.tws.company.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService extends AbstractUuidCrudService<Prescription> {

    public PrescriptionService(PrescriptionRepository repository) {
        super(repository);
    }
}
