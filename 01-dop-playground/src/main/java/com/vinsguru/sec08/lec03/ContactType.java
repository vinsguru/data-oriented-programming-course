package com.vinsguru.sec08.lec03;

public sealed interface ContactType {

    record EMail(String address) implements ContactType {

    }

    record Phone(String countryCode,
                 String number) implements ContactType {

    }

}
