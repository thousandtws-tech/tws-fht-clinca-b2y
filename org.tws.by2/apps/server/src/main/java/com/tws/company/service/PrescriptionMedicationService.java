package com.tws.company.service;

import com.tws.company.domain.PrescriptionMedication;
import com.tws.company.repository.PrescriptionMedicationRepository;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionMedicationService extends AbstractUuidCrudService<PrescriptionMedication> {

    public PrescriptionMedicationService(PrescriptionMedicationRepository repository) {
        super(repository);
    }
}
