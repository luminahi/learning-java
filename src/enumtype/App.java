package enumtype;

import enumtype.lib.Healer;
import enumtype.lib.Job;
import enumtype.lib.Type;

public class App {

    // private static void basicEnum() {
    //     Type fireType = Type.FIRE;
    //     Type waterType = Type.WATER;

    //     System.out.println(fireType);
    //     System.out.println(waterType);

    //     // System.out.println();
    //     for (Type value : Type.values()) {
    //         System.out.println(value.ordinal());
    //     }
    // }

    public static void main(String[] args) {
        // basicEnum(); 
        
        final Healer lux = new Healer(Job.KABBALIST, Type.LIGHT, 100);
        final Healer umbra = new Healer(Job.ORACLE, Type.DARK, 100);
        final Healer winda = new Healer(Job.PRIEST, Type.WIND, 75);
        final Healer ariel = new Healer(Job.MIKO, Type.WATER, 125);

        lux.heal();
        lux.attack();

        umbra.heal();
        umbra.attack();

        winda.heal();
        winda.attack();

        ariel.heal();
        ariel.attack();

    }
}
