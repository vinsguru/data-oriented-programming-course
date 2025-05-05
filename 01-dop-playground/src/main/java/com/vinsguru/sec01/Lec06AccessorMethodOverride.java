package com.vinsguru.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/*
* Record accessor methods can be overridden without changing their method signature.
* */
public class Lec06AccessorMethodOverride {

    private static final Logger log = LoggerFactory.getLogger(Lec06AccessorMethodOverride.class);

    record Person(String firstName,
                  String lastName){

        public String lastName(){
            return this.lastName.toUpperCase(); // just for demo
        }

        // public Optional<String> firstName(); Not valid
        public Optional<String> firstNameAsOptional(){
            return Optional.ofNullable(this.firstName);
        }

    }

    public static void main(String[] args) {

        var person = new Person("john", "doe");

        log.info("{}", person);


    }


}
