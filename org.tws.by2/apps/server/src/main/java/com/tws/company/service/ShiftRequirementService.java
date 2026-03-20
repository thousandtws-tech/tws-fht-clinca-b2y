package com.tws.company.service;

import com.tws.company.domain.ShiftRequirement;
import com.tws.company.repository.ShiftRequirementRepository;
import org.springframework.stereotype.Service;

@Service
public class ShiftRequirementService extends AbstractUuidCrudService<ShiftRequirement> {

    public ShiftRequirementService(ShiftRequirementRepository repository) {
        super(repository);
    }
}
