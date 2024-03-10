package com.luminahi.logging.lib;

import java.util.logging.Logger;

public class Feel {
    private static final Logger log = Logger.getLogger(Feel.class.getName());

    public Feel() {
        log.info("starting: " + this.getClass().getName());
    }
}
