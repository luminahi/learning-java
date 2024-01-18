package com.luminahi.interface_default.lib;

import java.util.function.Predicate;

@FunctionalInterface
public interface NumberValidator extends Predicate<Integer> {
    
    public static NumberValidator isEven() {
        NumberValidator fn = value -> value % 2 == 0;
        return fn;
    }

    public static NumberValidator isNegative() {
        NumberValidator fn = value -> value < 0;
        return fn;
    }

    public static NumberValidator isPositive() {
        NumberValidator fn = value -> value > 0;
        return fn;
    }

    public static NumberValidator isNumber() {
        NumberValidator fn = value -> {
            try {
                value = Integer.parseInt(value + "");
            } catch (Exception e) {
                return false;
            }
            return true;
        };

        return fn;        
    }

    public static NumberValidator isEqualTo100() {
        NumberValidator fn = value -> value == 100;
        return fn;
    }

    default NumberValidator and(NumberValidator other) {
        NumberValidator fn = number -> {
                boolean result = this.test(number);
                if (result) System.out.println("checked");
                return result ? other.test(number) : result;
            };

        return fn;
    }

}
