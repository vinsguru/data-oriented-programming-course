package com.vinsguru.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Two instances of a record are equal only if all of their components are equal
public class Lec01RecordBasicsDemo {

    private static final Logger log = LoggerFactory.getLogger(Lec01RecordBasicsDemo.class);

    record Person(String firstName,
                  String lastName){

    }

    public static void main(String[] args) {

        var person1 = new Person("john", "doe");
        var person2 = new Person("john", "doe");
        var person3 = new Person("alice", "doe");

        log.info("firstname: {}", person1.firstName());
        log.info("lastname: {}", person1.lastName());
        log.info("toString: {}", person1);

        log.info("person1 == person2: {}", (person1 == person2));
        log.info("person1 equals person2: {}", person1.equals(person2));
        log.info("person1 equals person3: {}", person1.equals(person3));

        log.info("person1 hashcode: {}", person1.hashCode());
        log.info("person2 hashcode: {}", person2.hashCode());
        log.info("person3 hashcode: {}", person3.hashCode());


    }


}
