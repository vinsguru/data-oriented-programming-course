package com.vinsguru.sec01.application.util;

import com.vinsguru.sec01.application.model.Payment;
import com.vinsguru.sec01.application.model.Payment.CreditCard;
import com.vinsguru.sec01.application.model.Payment.Paypal;
import com.vinsguru.sec01.persistence.entity.PaymentEntity;
import com.vinsguru.sec01.persistence.entity.PaymentType;

public class DomainEntityMapper {

    public static PaymentEntity toEntity(Payment payment){
        var entity = new PaymentEntity();
        switch (payment){
            case Paypal paypal -> addPaypalInfo(entity, paypal);
            case CreditCard creditCard -> addCreditCardInfo(entity, creditCard);
        }
        return entity;
    }

    private static void addPaypalInfo(PaymentEntity entity, Paypal paypal){
        entity.setEmail(paypal.email());
        entity.setType(PaymentType.PAYPAL);
    }

    private static void addCreditCardInfo(PaymentEntity entity, CreditCard creditCard){
        entity.setCvv(creditCard.cvv());
        entity.setNumber(creditCard.number());
        entity.setType(PaymentType.CREDIT_CARD);
    }

    public static Payment toDomain(PaymentEntity entity){
        return switch (entity.getType()){
            case PAYPAL -> new Payment.Paypal(entity.getEmail());
            case CREDIT_CARD -> new Payment.CreditCard(entity.getNumber(), entity.getCvv());
        };
    }

}
