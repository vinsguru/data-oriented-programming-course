package com.vinsguru.sec07.lec01;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    public static FileReadResponse readFile(Path path){
        try {
            return new FileReadResponse.Data(Files.readString(path));
        }catch (AccessDeniedException e){
            return new FileReadResponse.AccessDenied(e.getMessage());
        }catch (IOException e) {
            return new FileReadResponse.FileNotFound(e.getMessage());
        }
    }

}
