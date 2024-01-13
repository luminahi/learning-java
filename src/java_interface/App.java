package java_interface;

import java_interface.lib.element.DarkElement;
import java_interface.lib.element.Element;
import java_interface.lib.element.LightElement;
import java_interface.lib.hero.ElementalHero;
import java_interface.lib.hero.FireHero;
import java_interface.lib.hero.Hero;
import java_interface.lib.hero.WaterHero;

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