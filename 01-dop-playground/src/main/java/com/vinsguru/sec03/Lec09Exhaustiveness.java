package com.vinsguru.sec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec09Exhaustiveness {

    private static final Logger log = LoggerFactory.getLogger(Lec09Exhaustiveness.class);

    enum Country {
        US,
        UK,
        CA,
        AU
    }

    public static void main(String[] args) {

        log.info("{}", getTax(Country.US, 100));
        log.info("{}", getTax(Country.UK, 100));
        log.info("{}", getTax(Country.CA, 100));
        log.info("{}", getTax(Country.AU, 100));

    }

    private static double getTax(Country country, Integer price){
        var taxRate = switch (country){
            case US -> 0.05;
            case UK, AU -> 0.06;
            case CA -> 0.08;
        };
        log.info("country: {}, taxRate: {}", country, taxRate);
        return taxRate * price;
    }

}
