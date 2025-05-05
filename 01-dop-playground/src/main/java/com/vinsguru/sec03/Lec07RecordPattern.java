package com.vinsguru.sec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.HttpTimeoutException;

public class Lec07RecordPattern {

    private static final Logger log = LoggerFactory.getLogger(Lec07RecordPattern.class);

    // there is a better way to model this. this is for demo
    record ApiResponse<T>(T success,
                          Throwable error){
    }

    public static void main(String[] args) {

        patternMatch(new ApiResponse<>("sam", null));
        patternMatch(new ApiResponse<>(50, null));
        patternMatch(new ApiResponse<>(null, new HttpTimeoutException("unable to reach google.com")));
        patternMatch(new ApiResponse<>(null, null));

    }

    // record classes can be deconstructed and perform pattern matching on the record components as well
    private static void patternMatch(ApiResponse<?> response){
        switch (response){
            case ApiResponse(Integer data, _) -> log.info("int data: {}", data);
            case ApiResponse(String data, _) -> log.info("string data: {}", data);
            case ApiResponse(_, HttpTimeoutException ex) -> log.error("timed out: {}", ex.getMessage());
            case null, default -> log.error("unexpected :{}", response);
        }
    }
}
