package org.bagab.cdi_interceptor.appstarted;

import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.logging.Logger;

/**
 * Application lifecycle, Global scope
 */
@Singleton
@Startup
@LocalBean
public class Application {
    private static Logger log = Logger.getLogger("Application");

    private boolean started = false;

    @Lock(LockType.READ)
    public boolean  isStarted() {
        return started;
    }


    public void start() {
        log.info("STARTED!");
        started = true;
    }


    public void stop() {
        log.info("STOPPED!");
        started = false;
    }

}
