package com.vinsguru.sec07.lec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

// just for demo
public class ExternalServiceClient {

    private static final Logger log = LoggerFactory.getLogger(ExternalServiceClient.class);

    public static Result<String> call(String url){
        try(var stream = URI.create(url).toURL().openStream()){
            return Result.success(new String(stream.readAllBytes())); // response size is small
        }catch (Exception e){
            return Result.failure(e);
        }
    }

}
