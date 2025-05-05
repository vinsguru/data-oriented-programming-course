package com.vinsguru.sec04.lec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EMailService {

    private static final Logger log = LoggerFactory.getLogger(EMailService.class);


    // what if the caller switches parameters?
    // is it a valid email?
    // is the message valid?
    public static void send(String emailAddress, String message) {
        log.info("sending {} to {}", message, emailAddress);
    }


    public static void send(EMailAddress eMailAddress, Message message){
        log.info("sending {} to {}", message.value(), eMailAddress.value());
    }


}
