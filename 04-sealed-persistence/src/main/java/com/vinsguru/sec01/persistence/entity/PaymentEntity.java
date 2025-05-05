package com.vinsguru.sec01.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private PaymentType type;

    private String number;  // for credit card
    private String cvv;     // for credit card
    private String email;   // for paypal

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", type=" + type +
                ", number='" + number + '\'' +
                ", cvv='" + cvv + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
