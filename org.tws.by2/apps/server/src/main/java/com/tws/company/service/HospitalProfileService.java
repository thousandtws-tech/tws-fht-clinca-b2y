package com.tws.company.service;

import com.tws.company.domain.HospitalProfile;
import com.tws.company.repository.HospitalProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalProfileService extends AbstractUuidCrudService<HospitalProfile> {

    public HospitalProfileService(HospitalProfileRepository repository) {
        super(repository);
    }
}
