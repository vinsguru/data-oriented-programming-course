package com.vinsguru.sec07.lec02;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    public static Result<String> readFile(Path path){
        try {
            return Result.success(Files.readString(path));
        }catch (Exception e){
            return Result.failure(e);
        }
    }

}
