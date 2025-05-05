package com.vinsguru.sec02.lec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// just for demo
public record CreditCard(String number) implements Payment {

    private static final Logger log = LoggerFactory.getLogger(CreditCard.class);

    @Override
    public void process(int amount) {
        log.info("processing amount {} using CC {}", amount, this.number());
    }

}
