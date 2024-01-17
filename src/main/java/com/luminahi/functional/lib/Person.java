package com.luminahi.functional.lib;

public class Person {

    public final String name;
    public final Gender gender;

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public boolean isFemale() {
        return gender.equals(Gender.FEMALE);
    }

    @Override
    public String toString() {
        return name;
    }
}
