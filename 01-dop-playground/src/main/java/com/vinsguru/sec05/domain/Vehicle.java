package com.vinsguru.sec05.domain;

public sealed interface Vehicle {

    String make();

    record Car(String make,
               int year) implements Vehicle {

    }

    record Motorcycle(String make,
                      int engineCC) implements Vehicle {

    }

}
