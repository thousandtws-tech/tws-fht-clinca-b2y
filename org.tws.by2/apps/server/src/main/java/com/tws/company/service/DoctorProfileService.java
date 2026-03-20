package com.tws.company.service;

import com.tws.company.domain.DoctorProfile;
import com.tws.company.repository.DoctorProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorProfileService extends AbstractUuidCrudService<DoctorProfile> {

    public DoctorProfileService(DoctorProfileRepository repository) {
        super(repository);
    }
}
