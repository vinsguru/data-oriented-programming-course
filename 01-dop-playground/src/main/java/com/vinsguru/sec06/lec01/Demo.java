package com.vinsguru.sec06.lec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {

    private static final Logger log = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {

        log.info("present: {}", getCustomer(1).orElse("missing"));
        log.info("missing: {}", getCustomer(11).orElse("missing"));

    }

    private static Option<String> getCustomer(int id){
        return id == 1 ? Option.data("sam") : Option.absent();
    }

}
