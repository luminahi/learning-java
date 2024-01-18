package com.luminahi.combinatorpattern;

import java.time.LocalDate;

import com.luminahi.combinatorpattern.lib.Customer;
import static com.luminahi.combinatorpattern.lib.CustomerValidator.*;
import com.luminahi.combinatorpattern.lib.ValidationResult;

public class App {
    public static void main(String[] args) {
        var sarah = new Customer("sarah", "sarahmail.com", "a929291000", LocalDate.of(2000, 1, 1));
        

        ValidationResult result = isAdult()
            .and(isEmailValid())
            .and(isPhoneNumberValid())
            .apply(sarah);
        
        System.out.println(result);
    }
}
