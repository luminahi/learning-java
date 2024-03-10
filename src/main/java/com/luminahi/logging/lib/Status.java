package com.luminahi.logging.lib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Status {
    
    private static final Logger log = LoggerFactory.getLogger(Status.class);

    public Status() {
        log.debug("status started");
    }

}
