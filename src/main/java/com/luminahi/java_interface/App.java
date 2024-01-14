package com.luminahi.java_interface;

import com.luminahi.java_interface.lib.element.DarkElement;
import com.luminahi.java_interface.lib.element.Element;
import com.luminahi.java_interface.lib.element.LightElement;
import com.luminahi.java_interface.lib.hero.ElementalHero;
import com.luminahi.java_interface.lib.hero.FireHero;
import com.luminahi.java_interface.lib.hero.Hero;
import com.luminahi.java_interface.lib.hero.WaterHero;

public class App {
    public static void main(String[] args) {
        
        Hero hiita = new FireHero("hiita", 1500, 0);
        Hero ariel = new WaterHero("ariel", 500, 2000);
    
        Element light = new LightElement();
        Element dark = new DarkElement();

        Hero lux = new ElementalHero<Element>("lux", 0, 2500, light);
        Hero umbra = new ElementalHero<Element>("umbra", 0, 2500, dark);

        System.out.println(lux);
        System.out.println(umbra);

        System.out.println(hiita);
        System.out.println(ariel);
    }
}