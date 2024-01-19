package com.luminahi.combinatorpattern.lib2;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class StringValidator {
    private Optional<String> word;
    private List<String> errors = new LinkedList<>();
    private boolean isNull = false;

    public StringValidator(String word) {
        this.word = Optional.ofNullable(word);
    }
    
    public StringValidator isString() {
        if (word.isEmpty()) {
            isNull = true;
            return this;
        };
        if (!(word.get() instanceof String)) {
            errors.add("not a string");
        }
        
        return this;
    }

    public StringValidator isNotBlank() {
        if (word.isEmpty()) {
            isNull = true;
            return this;
        };
        if (word.get().isBlank()) {
            errors.add("blank string");
        }
        
        return this;
    }

    public StringValidator lengthGreaterThan10() {
        if (word.isEmpty()) {
            isNull = true;
            return this;
        }
        if (word.get().length() <= 10) {
            errors.add("not greater than 10");
        }

        return this;
    }

    public boolean isSuccess() {
        return this.errors.size() > 0 || isNull ? false : true;
    }

    public List<String> getErrors() {
        System.out.println("ulala");
        return errors;
    }
}
