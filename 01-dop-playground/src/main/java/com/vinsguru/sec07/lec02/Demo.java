package com.vinsguru.sec07.lec02;

import com.vinsguru.sec07.lec02.Result.Failure;
import com.vinsguru.sec07.lec02.Result.Success;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Path;

public class Demo {

    private static final Logger log = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {

        //readFile(Path.of("myfile3.txt"));

        //callExternalService("https://google.com");


    }

    private static void readFile(Path path){
        switch (FileReader.readFile(path)){
            case Success(String data) -> log.info("data: {}", data);
            case Failure(AccessDeniedException e) -> log.error("denied: {}", e.getMessage());
            case Failure(IOException e) -> log.error("io error: {}", e.getMessage());
            case Failure(Throwable e) -> log.error("error: {}", e.getMessage());
        }
    }

    private static void callExternalService(String url){
        log.info("{}", ExternalServiceClient.call(url));
    }

}
