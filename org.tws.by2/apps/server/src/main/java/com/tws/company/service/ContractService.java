package com.tws.company.service;

import com.tws.company.domain.Contract;
import com.tws.company.repository.ContractRepository;
import org.springframework.stereotype.Service;

@Service
public class ContractService extends AbstractUuidCrudService<Contract> {

    public ContractService(ContractRepository repository) {
        super(repository);
    }
}
