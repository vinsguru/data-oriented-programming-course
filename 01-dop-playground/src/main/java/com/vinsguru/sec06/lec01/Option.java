package com.vinsguru.sec06.lec01;

import java.util.Objects;

public sealed interface Option<T> {

    record Present<T>(T value) implements Option<T> {

    }

    record Absent<T>() implements Option<T> {
        private static final Option<?> ABSENT = new Absent<>();
    }

    static <T> Option<T> data(T value){
        return Objects.nonNull(value) ? new Present<>(value) : absent();
    }

    @SuppressWarnings("unchecked")
    static <T> Option<T> absent(){
        return (Option<T>) Absent.ABSENT;
    }

    default boolean isPresent(){
        return this instanceof Option.Present<T>;
    }

    default T orElse(T defaultValue){
        return switch (this){
            case Present(T value) -> value;
            case Absent() -> defaultValue;
        };
    }

}
