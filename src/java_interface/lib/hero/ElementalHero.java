package java_interface.lib.hero;

import java_interface.lib.element.Element;

public class ElementalHero<T extends Element> implements Hero {
    private final T element;
    private String name;
    private int offense;
    private int defense;
    
    public ElementalHero(String name, int offense, int defense, T element) {
        this.name = name;
        this.offense = offense;
        this.defense = defense;
        this.element = element;
    }

    public String getElement() {
        return element.getElement();
    }

    @Override
    public int attack() {
        System.out.println(name + " hero use a " + element.getElement() + "attack");
        return offense;
    }

    @Override
    public int defend() {
        System.out.println(name + " hero defends");
        return defense;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", name, getElement());
    }
}
