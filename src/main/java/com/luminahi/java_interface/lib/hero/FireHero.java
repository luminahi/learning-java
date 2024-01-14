package com.luminahi.java_interface.lib.hero;

public class FireHero implements Hero {
    private static final String ATTRIBUTE = "fire";
    private String name;
    private int offense;
    private int defense;

    public FireHero(String name, int offense, int defense) {
        this.name = name;
        this.offense = offense;
        this.defense = defense;
    }

    @Override
    public String getElement() {
        return ATTRIBUTE;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", name, ATTRIBUTE);
    }

    @Override
    public int attack() {
        System.out.println(name + " hero use a " + ATTRIBUTE + "attack");
        return offense;
    }

    @Override
    public int defend() {
        System.out.println(name + " hero defends");
        return defense;
    }
}
