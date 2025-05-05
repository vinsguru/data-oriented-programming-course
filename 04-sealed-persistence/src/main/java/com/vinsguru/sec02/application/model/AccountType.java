package com.vinsguru.sec02.application.model;

public sealed interface AccountType {

    Integer accountNumber();
    Integer balance();

    record Checking(Integer accountNumber,
                    Integer balance,
                    Integer overDraftLimit) implements AccountType {

    }

    record Savings(Integer accountNumber,
                   Integer balance,
                   Double interestRate) implements AccountType {

    }

}
