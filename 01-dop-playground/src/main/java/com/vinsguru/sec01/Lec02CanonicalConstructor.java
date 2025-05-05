package com.vinsguru.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
* Canonical constructors can be annoying when you need to modify a single field in a record with many components.
* */
public class Lec02CanonicalConstructor {

    private static final Logger log = LoggerFactory.getLogger(Lec02CanonicalConstructor.class);

    record Person(String firstName,
                  String lastName){

        public Person(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName.toUpperCase();
        }

    }

    public static void main(String[] args) {

        var person = new Person("john", "doe");

        log.info("{}", person);


    }


}
