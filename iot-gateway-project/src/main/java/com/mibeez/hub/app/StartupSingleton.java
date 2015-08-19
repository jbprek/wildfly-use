package com.mibeez.hub.app;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.logging.Logger;

/**
 * @author prekezes.
 */
@Startup
@Singleton
public class StartupSingleton {
    private static final Logger log = Logger.getLogger(StartupSingleton.class.getName());

    @PostConstruct
    private void setup() {
        log.warning("KAKA");
    }
}
