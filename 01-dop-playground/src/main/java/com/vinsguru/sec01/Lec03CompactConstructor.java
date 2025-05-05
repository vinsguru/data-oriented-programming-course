package com.vinsguru.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/*
 * Compact constructors are good to add validation/processing logic
 * */
public class Lec03CompactConstructor {

    private static final Logger log = LoggerFactory.getLogger(Lec03CompactConstructor.class);

    record Person(String firstName,
                  String lastName){

        Person {
            Objects.requireNonNull(lastName, "Lastname can not be null");
            lastName = lastName.toUpperCase();
        }

    }

    public static void main(String[] args) {

        var person = new Person("john", "doe");

        log.info("{}", person);

    }


}
