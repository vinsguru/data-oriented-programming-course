package com.vinsguru.sec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec06UnnamedVariable {

    private static final Logger log = LoggerFactory.getLogger(Lec06UnnamedVariable.class);

    public static void main(String[] args) {

        patternMatch(5);
        patternMatch(5.0);
        patternMatch(5.0f);

    }

    private static void patternMatch(Object object){
        switch (object){
            case Double _ -> log.info("received double");
            case Integer _ -> log.info("received int");
            case null, default -> log.info("null/default: {}", object);
        }
    }

}
