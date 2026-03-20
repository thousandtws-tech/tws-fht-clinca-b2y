package com.tws.company.service;

import com.tws.company.domain.Patient;
import com.tws.company.repository.PatientRepository;
import com.tws.company.service.dto.FindOrCreatePatientRequest;
import com.tws.company.service.dto.FindOrCreatePatientResponse;
import com.tws.company.service.mapper.PatientMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
public class PatientRegistrationService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientRegistrationService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Transactional
    public Mono<FindOrCreatePatientResponse> findOrCreate(FindOrCreatePatientRequest request) {
        if (request.cpf() == null || request.name() == null || request.birthDate() == null || request.phone() == null) {
            return Mono.error(new IllegalArgumentException("Nome, CPF, data de nascimento e telefone sao obrigatorios."));
        }

        return patientRepository
            .findOneByCpf(request.cpf())
            .flatMap(existing -> {
                patientMapper.apply(existing, request);
                return patientRepository.save(existing).thenReturn(new FindOrCreatePatientResponse(existing.getId(), false));
            })
            .switchIfEmpty(Mono.defer(() -> patientRepository.save(patientMapper.create(request)).map(saved -> new FindOrCreatePatientResponse(saved.getId(), true))));
    }
}
