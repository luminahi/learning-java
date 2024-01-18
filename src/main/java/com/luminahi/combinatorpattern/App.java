package com.luminahi.combinatorpattern;

import java.time.LocalDate;

import com.luminahi.combinatorpattern.lib.Customer;
import com.luminahi.combinatorpattern.lib.CustomerValidator;

public class App {
    public static void main(String[] args) {
        var sarah = new Customer("sarah", "sarahmail.com", "a929291000", LocalDate.of(2000, 1, 1));
        

        var result = CustomerValidator.isAdult()
            .and(CustomerValidator.isEmailValid())
            .and(CustomerValidator.isPhoneNumberValid());
        
    }
}
