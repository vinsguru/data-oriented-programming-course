package com.vinsguru.sec02.application.util;

import com.vinsguru.sec02.application.model.AccountType;
import com.vinsguru.sec02.persistence.entity.Account;
import com.vinsguru.sec02.persistence.entity.CheckingAccount;
import com.vinsguru.sec02.persistence.entity.SavingsAccount;

public class DomainEntityMapper {

    public static Account toEntity(AccountType accountType){
        var entity = switch (accountType){
            case AccountType.Checking checking -> createCheckingAccount(checking);
            case AccountType.Savings savings -> createSavingsAccount(savings);
        };
        entity.setAccountNumber(accountType.accountNumber());
        entity.setBalance(accountType.balance());
        return entity;
    }

    private static Account createCheckingAccount(AccountType.Checking checking){
        var entity = new CheckingAccount();
        entity.setOverdraftLimit(checking.overDraftLimit());
        return entity;
    }

    private static Account createSavingsAccount(AccountType.Savings savings){
        var entity = new SavingsAccount();
        entity.setInterestRate(savings.interestRate());
        return entity;
    }

    public static AccountType toDomain(Account account){
        return switch (account){
            case CheckingAccount checking -> new AccountType.Checking(checking.getAccountNumber(), checking.getBalance(), checking.getOverdraftLimit());
            case SavingsAccount savings -> new AccountType.Savings(savings.getAccountNumber(), savings.getBalance(), savings.getInterestRate());
            default -> throw new IllegalStateException("Unexpected value: " + account); // should not happen
        };
    }

}
