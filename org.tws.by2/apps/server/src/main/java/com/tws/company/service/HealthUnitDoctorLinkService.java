package com.tws.company.service;

import com.tws.company.domain.HealthUnitDoctorLink;
import com.tws.company.repository.HealthUnitDoctorLinkRepository;
import org.springframework.stereotype.Service;

@Service
public class HealthUnitDoctorLinkService extends AbstractUuidCrudService<HealthUnitDoctorLink> {

    public HealthUnitDoctorLinkService(HealthUnitDoctorLinkRepository repository) {
        super(repository);
    }
}
