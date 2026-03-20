package com.tws.company.service;

import com.tws.company.domain.DoctorTimeSlot;
import com.tws.company.repository.DoctorTimeSlotRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorTimeSlotService extends AbstractUuidCrudService<DoctorTimeSlot> {

    public DoctorTimeSlotService(DoctorTimeSlotRepository repository) {
        super(repository);
    }
}
