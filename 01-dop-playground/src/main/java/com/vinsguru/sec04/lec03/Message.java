package com.vinsguru.sec04.lec03;

import java.util.Objects;

public record Message(String value) {

    public Message {
        if(Objects.isNull(value) || value.length() < 10 || value.length() > 5000){
            throw new IllegalArgumentException("Not a valid message");
        }
    }

}
