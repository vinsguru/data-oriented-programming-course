package com.vinsguru.sec02.lec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public sealed class Cash extends Payment permits CashRewards {

    private static final Logger log = LoggerFactory.getLogger(Cash.class);

    @Override
    public void process(int amount) {
        log.info("processing: {}", amount);
    }

}
