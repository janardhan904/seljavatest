package org.example.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Loggers {
    private static final Logger log = LogManager.getLogger(Logger.class);

    public static void main(String[] args) {
        System.out.println( "Hello, JD!" );
        log.trace("trace the user!");
        log.debug("debug the user!");
        log.info("info the user!");
        log.warn("warn the user!");
        log.error("error the user!");
        log.fatal("fatal the user!");
    }
}
