package com.vinsguru.sec04.lec02;

public sealed interface ContactType {

    record EMail(String address) implements ContactType {

    }

    record Phone(String countryCode,
                 String number) implements ContactType {

    }

}
