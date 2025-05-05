package com.vinsguru.sec02.application.service;

import com.vinsguru.sec02.application.model.AccountType;
import com.vinsguru.sec02.persistence.entity.Account;
import com.vinsguru.sec02.persistence.repository.AccountRepository;
import com.vinsguru.sec02.application.util.DomainEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountRepository repository;

    public void save(AccountType accountType){
        var entity = DomainEntityMapper.toEntity(accountType);
        this.repository.save(entity);
        log.info("account saved successfully");
    }

    public AccountType getAccount(Integer id) {
        return this.repository.findById(id)
                              .map(DomainEntityMapper::toDomain)
                              .orElseThrow();
    }

    public void printAllRecords() {
        this.repository.findAll()
                       .stream()
                       .map(Account::toString)
                       .forEach(log::info);
    }
}
