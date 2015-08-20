package com.mibeez.hub.app;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.logging.Logger;

/**
 * @author prekezes.
 */
@Startup
@Singleton
@DependsOn("HardwareMonitor")
public class StartupSingleton {
    private static final Logger log = Logger.getLogger(StartupSingleton.class.getName());

    @PostConstruct
    private void setup() {
        log.warning("Application Start");
    }
}
