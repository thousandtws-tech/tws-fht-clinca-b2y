package com.tws.company.service;

import com.tws.company.domain.UserAccount;
import com.tws.company.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService extends AbstractUuidCrudService<UserAccount> {

    public UserAccountService(UserAccountRepository repository) {
        super(repository);
    }
}
