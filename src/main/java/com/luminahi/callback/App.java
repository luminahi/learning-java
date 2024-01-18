package com.luminahi.callback;

import java.util.function.Function;

public class App {
    
    private static void hello(String firstName, String lastName, Runnable runnable) {
        System.out.println(firstName);
        if (lastName == null)
            runnable.run();
        else
            System.out.println(lastName);
    }

    private static void hello(String name, Function<String, String> function) {
        System.out.println(function.apply(name));
    }

    public static void main(String[] args) {
        hello("lux", null, () -> System.out.println("not good"));
        hello("lux", String::toUpperCase);
    }
}
