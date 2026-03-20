package com.tws.company.service;

import com.tws.company.domain.Patient;
import com.tws.company.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends AbstractUuidCrudService<Patient> {

    public PatientService(PatientRepository repository) {
        super(repository);
    }
}
