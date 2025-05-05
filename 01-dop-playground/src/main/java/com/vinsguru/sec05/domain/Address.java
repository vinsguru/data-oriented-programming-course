package com.vinsguru.sec05.domain;

// ignoring validation for simplicity as it has been discussed already
public record Address(String street,
                      String city,
                      String zipCode) {
}
