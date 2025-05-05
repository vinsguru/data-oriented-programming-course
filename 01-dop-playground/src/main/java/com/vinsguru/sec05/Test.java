package com.vinsguru.sec05;


public class Test {

    record Box(int value) {}
    static String test(Object o) {
        return switch (o) {
            case Box(int value) when value > 0 -> "Positive box";
            case Box b -> "Box with value: " + b.value();
            default -> "Default";
        };
    }

    public static void main(String[] args) {




        System.out.println(test(new Box(5)));



    }

}
