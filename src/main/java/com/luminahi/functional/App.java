package com.luminahi.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.luminahi.functional.lib.Gender;
import com.luminahi.functional.lib.Person;

public class App {

    public static void main(String[] args) {
        
        List<Person> people = List.of(
            new Person("Alex", Gender.MALE),
            new Person("Sarah", Gender.FEMALE),
            new Person("Sora", Gender.FEMALE),
            new Person("Haruka", Gender.MALE),
            new Person("Pedro", Gender.MALE),
            new Person("Alyx", Gender.FEMALE)
        );

        people
            .stream()
            .filter(Person::isFemale)
            .forEach(System.out::println);

        List<Integer> integers = Arrays.asList(10, 20, 1, 5, 7, 15);

        integers.stream().filter(isEven).forEach(System.out::println);
        integers.stream().map(doubleValue).forEach(System.out::println);
    }

    static Predicate<Integer> isEven = (Integer value) -> value % 2 == 0;
    static Function<Integer, Integer> doubleValue = (Integer value) -> value * 2;

    public static class Good {
        public String name;

        public Good(String name) {
            this.name = name;
        }
    }
}


