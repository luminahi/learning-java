package com.luminahi.combinatorpattern.lib;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import static com.luminahi.combinatorpattern.lib.ValidationResult.*;

@FunctionalInterface
public interface CustomerValidator extends Function<Customer, ValidationResult> {

    static CustomerValidator isEmailValid() {
        return customer -> customer.email().contains("@") ? SUCCESS : INVALID_EMAIL;
    }

    static CustomerValidator isPhoneNumberValid() {
        return customer -> customer.phoneNumber().startsWith("9") ? SUCCESS : INVALID_PHONE_NUMBER;
    }

    static CustomerValidator isAdult() {
        return customer -> Period.between(customer.dateOfBirth(), LocalDate.now()).getYears() > 16 ? SUCCESS : NOT_A_ADULT;
    }

    default CustomerValidator and(CustomerValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer): result;
        };
    }
}

