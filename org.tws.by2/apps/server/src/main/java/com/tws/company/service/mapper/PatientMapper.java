package com.tws.company.service.mapper;

import com.tws.company.domain.Patient;
import com.tws.company.service.dto.FindOrCreatePatientRequest;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {

    public Patient create(FindOrCreatePatientRequest request) {
        Patient patient = new Patient();
        patient.setId(UUID.randomUUID());
        apply(patient, request);
        patient.setCreatedBy("system");
        patient.setLastModifiedBy("system");
        return patient;
    }

    public Patient apply(Patient patient, FindOrCreatePatientRequest request) {
        patient.setCpf(request.cpf());
        patient.setName(request.name());
        patient.setBirthDate(request.birthDate());
        patient.setPhone(request.phone());
        patient.setEmail(request.email());
        return patient;
    }
}
