package com.tws.company.service;

import com.tws.company.domain.TimeRecord;
import com.tws.company.repository.TimeRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class TimeRecordService extends AbstractUuidCrudService<TimeRecord> {

    public TimeRecordService(TimeRecordRepository repository) {
        super(repository);
    }
}
