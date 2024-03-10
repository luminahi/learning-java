package com.luminahi.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.luminahi.logging.lib.Feel;
import com.luminahi.logging.lib.Status;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        log.info("Hello World");
        log.warn("Hello World");
        log.error("Hello World");
        new Status();
        new Feel();
        System.out.println("=================");

        log.atError().setMessage("something wrong").log();
    }
}
