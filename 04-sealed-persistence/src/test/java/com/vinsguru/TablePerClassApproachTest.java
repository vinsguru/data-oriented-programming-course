package com.vinsguru;

import com.vinsguru.sec02.application.model.AccountType;
import com.vinsguru.sec02.application.service.AccountService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TablePerClassApproachTest {

    private static final Logger log = LoggerFactory.getLogger(TablePerClassApproachTest.class);

    @Autowired
    private AccountService accountService;

    @Test
    void entitySaveRetrieve() {

        // savings account
       var savings = new AccountType.Savings(null, 10000, 5.0);
       this.accountService.save(savings);

       // checking
       var checking = new AccountType.Checking(null, 5000, 300);
       this.accountService.save(checking);

       // query by id
        log.info("{}", this.accountService.getAccount(1));
        log.info("{}", this.accountService.getAccount(2));


        // query all
        this.accountService.printAllRecords();

    }

}
