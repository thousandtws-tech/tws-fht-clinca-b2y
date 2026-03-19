package com.tws.company.service;

import com.tws.company.domain.BillingItem;
import com.tws.company.repository.BillingItemRepository;
import org.springframework.stereotype.Service;

@Service
public class BillingItemService extends AbstractUuidCrudService<BillingItem> {

    public BillingItemService(BillingItemRepository repository) {
        super(repository);
    }
}
