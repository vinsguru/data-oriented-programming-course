package com.vinsguru.sec06.lec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {

    private static final Logger log = LoggerFactory.getLogger(Demo.class);

    // 3 rd party lib. not sealed
    record Phone(String number) {}
    record EMail(String address) {}

    public static void main(String[] args) {

        log.info("left: {}", getContactMethod(1));
        log.info("right: {}", getContactMethod(2));

        switch (getContactMethod(2)){
            case Either.Left(Phone phone) -> log.info("sending message to number {}", phone.number());
            case Either.Right(EMail eMail) -> log.info("sending message to email {}", eMail.address());
        }

    }

    // proper types. we are NOT sending 'Object'
    private static Either<Phone, EMail> getContactMethod(int id){
        return id == 1 ? Either.left(new Phone("123-456-7890")) : Either.right(new EMail("sam@gmail.com"));
    }
}
