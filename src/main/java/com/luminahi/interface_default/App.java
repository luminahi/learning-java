package com.luminahi.interface_default;

import static com.luminahi.interface_default.lib.NumberValidator.*;

public class App {
    public static void main(String[] args) {
        var check = isEven()
            .and(isPositive())
            .and(isEqualTo100())
            .test(-1);
        
        System.out.println(check);
    }
}
