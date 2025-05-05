package com.vinsguru.sec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec04PatternLabelDominance {

    private static final Logger log = LoggerFactory.getLogger(Lec04PatternLabelDominance.class);

    public static void main(String[] args) {

        patternMatch((short)5);
        patternMatch(5);
        patternMatch(5.0);
        patternMatch(5.0f);
        patternMatch(5_000_000_000L);

    }

    private static void patternMatch(Object object){
        switch (object){
            case Short s -> log.info("short {}", s);
            case Double d -> log.info("double {}", d);
            case Integer i -> log.info("int {}", i);
            case Number n -> log.info("number {}", n);
            case null, default -> log.info("null/default: {}", object);
        }
    }
}
