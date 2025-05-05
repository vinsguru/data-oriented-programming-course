package com.vinsguru.sec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.HttpTimeoutException;

public class Lec08NestedRecordPattern {

    private static final Logger log = LoggerFactory.getLogger(Lec08NestedRecordPattern.class);

    // there is a better way to model this. this is for demo
    record ApiResponse<T>(T success,
                          Throwable error){
    }

    record Product(String name,
                   int price){
    }

    record User(String name,
                String email){
    }

    public static void main(String[] args) {

        patternMatch(new ApiResponse<>("sam", null));
        patternMatch(new ApiResponse<>(new Product("tv", 100), null));
        patternMatch(new ApiResponse<>(new User("sam", "sam@gmail.com"), null));
        patternMatch(new ApiResponse<>(null, new HttpTimeoutException("unable to reach google.com")));
        patternMatch(new ApiResponse<>(null, null));

    }

    // record classes can be deconstructed and perform pattern matching on the record components as well
    private static void patternMatch(ApiResponse<?> response){
        switch (response){
            case ApiResponse(Product(var name, _), _) -> log.info("product name: {}", name);
            case ApiResponse(User user, _) -> log.info("user email: {}", user.email()); // intentional
            case ApiResponse(String data, _) -> log.info("string data: {}", data);
            case ApiResponse(_, HttpTimeoutException ex) -> log.error("timed out: {}", ex.getMessage());
            case null, default -> log.error("unexpected :{}", response);
        }
    }
}
