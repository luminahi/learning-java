package com.luminahi.combinatorpattern;

import com.luminahi.combinatorpattern.lib2.*;

public class App2 {
    public static void main(String args[]) {
        var myName = new StringValidator("");
        var result = myName
            .isString()
            .isNotBlank()
            .lengthGreaterThan10();

        if (!result.isSuccess()) {
            for (String error : result.getErrors()) {
                System.out.println(error);
            }
        }
    }
}
