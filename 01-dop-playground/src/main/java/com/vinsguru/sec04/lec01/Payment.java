package com.vinsguru.sec04.lec01;

public sealed interface Payment {

    record CreditCard(String number,
                      String cvv) implements Payment {

    }

    record Paypal(String email) implements Payment {

    }

}
