package com.vinsguru.sec01.application.model;

public sealed interface Payment {

    record CreditCard(String number,
                      String cvv) implements Payment {

    }


    record Paypal(String email) implements Payment {

    }

}
