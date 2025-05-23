package com.vinsguru.sec06.lec02;

public sealed interface Either<L, R> {

    record Left<L, R>(L value) implements Either<L, R> {

    }

    record Right<L, R>(R value) implements Either<L, R> {

    }

    static <L, R> Either<L, R> left(L value){
        return new Left<>(value);
    }

    static <L, R> Either<L, R> right(R value){
        return new Right<>(value);
    }

}
