package com.vinsguru.sec02.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "checking_account")
public final class CheckingAccount extends Account {

    private Integer overdraftLimit;

    public Integer getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(Integer overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "overdraftLimit=" + overdraftLimit +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }

}
