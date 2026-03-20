package com.tws.company.service;

import com.tws.company.domain.Appointment;
import com.tws.company.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService extends AbstractUuidCrudService<Appointment> {

    public AppointmentService(AppointmentRepository repository) {
        super(repository);
    }
}
