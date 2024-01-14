package com.luminahi.generics;

import java.util.Arrays;
import java.util.List;

import com.luminahi.generics.lib.GenericPrinter;
import com.luminahi.generics.lib.vehicle.Bike;
import com.luminahi.generics.lib.vehicle.Car;
import com.luminahi.generics.lib.vehicle.Vehicle;

public class App {

    private static void typePrinter() {
        GenericPrinter<String> stringPrinter = 
            new GenericPrinter<>("lux lumina");

        GenericPrinter<Integer> integerPrinter = 
            new GenericPrinter<>(200);

        GenericPrinter<Character> characterPrinter = 
            new GenericPrinter<>('a');

        integerPrinter.print();
        stringPrinter.print();
        characterPrinter.print();
    }

    private static <T extends Vehicle> void printRunningVehicle(T vehicle) {
        String text = "Running with: " + vehicle.getNumberOfWheels() + " wheels";
        System.out.println(text);
    }

    private static void printList(List<?> list) {
        for (var item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static <T, V> T genericArgsAndGenericReturn(T thing, V another) {
        System.out.println(thing);
        System.out.println(another);
        return thing;
    }

    public static void main(String[] args) {
        typePrinter();

        printRunningVehicle(new Bike("cool bike brand"));
        printRunningVehicle(new Car("cool car brand"));

        printList(Arrays.asList(2, 20, 10, 80));
        printList(Arrays.asList(
            new Car("Fiat"), 
            new Car("Ford"), 
            new Car("Lamborghini")
        ));

        String genericVar = genericArgsAndGenericReturn("lumia", 200);
        System.out.println(genericVar);
    }
}