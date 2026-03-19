package com.tws.company.service;

import com.tws.company.domain.Consultation;
import com.tws.company.repository.ConsultationRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultationService extends AbstractUuidCrudService<Consultation> {

    public ConsultationService(ConsultationRepository repository) {
        super(repository);
    }
}
