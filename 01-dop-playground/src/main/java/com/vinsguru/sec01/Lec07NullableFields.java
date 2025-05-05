package com.vinsguru.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/*
* Records are data carriers, and their fields can be null. 
* If you want to prevent null, use a compact constructor to validate the fields 
* or use Optional to make it explicit.
* */
public class Lec07NullableFields {

    private static final Logger log = LoggerFactory.getLogger(Lec07NullableFields.class);

    record Person(String name,
                  Optional<String> nickName) {

        Person(String name){
            this(name, Optional.empty());
        }

        Person(String name, String nickName){
            this(name, Optional.ofNullable(nickName));
        }

    }

    public static void main(String[] args) {

        var sam = new Person("sam");
        var william = new Person("william", "bill");

        log.info("{}", sam);
        log.info("{}", william);

    }



}
