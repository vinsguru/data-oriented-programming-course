package com.vinsguru.sec07.lec02;

public sealed interface Result<T> {

    record Success<T>(T data) implements Result<T> {

    }

    record Failure<T>(Throwable throwable) implements Result<T> {

    }

    static <T> Result<T> success(T data){
        return new Success<>(data);
    }

    static <T> Result<T> failure(Throwable throwable){
        return new Failure<>(throwable);
    }

    default T orElse(T defaultValue){
        return switch (this){
            case Success(T data) -> data;
            case Failure(_) -> defaultValue;
        };
    }

}
