package com.vinsguru.sec07.lec01;

public sealed interface FileReadResponse {

    record Data(String content) implements FileReadResponse {

    }

    record FileNotFound(String message) implements FileReadResponse {

    }

    record AccessDenied(String message) implements FileReadResponse {

    }

}
