package com.vinsguru.sec05.domain;

// ignoring validation for simplicity as it has been discussed already
public record LoanApplication(Applicant applicant,
                              LoanTerms terms) {
}
