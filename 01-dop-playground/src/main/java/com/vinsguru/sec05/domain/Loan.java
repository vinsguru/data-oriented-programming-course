package com.vinsguru.sec05.domain;

public sealed interface Loan {

    LoanApplication application();

    record PersonalLoan(LoanApplication application) implements Loan {

    }

    record PropertyLoan(LoanApplication application,
                        Property property) implements Loan {

    }

    record AutoLoan(LoanApplication application,
                    Vehicle vehicle) implements Loan {

    }

}
