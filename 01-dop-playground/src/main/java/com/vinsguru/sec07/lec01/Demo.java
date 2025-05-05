package com.vinsguru.sec07.lec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.vinsguru.sec07.lec01.FileReadResponse.*;

import java.nio.file.Path;

public class Demo {

    private static final Logger log = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {

        readFile(Path.of("myfile3.txt"));

    }

    private static void readFile(Path path){
        switch (FileReader.readFile(path)){
            case Data data -> log.info("data: {}", data.content());
            case AccessDenied denied -> log.error("denied: {}", denied.message());
            case FileNotFound fileNotFound -> log.error("not found: {}", fileNotFound.message());
        }
    }

}
