package org.bagab.interceptors.cdi;

import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author prekezes.
 */
@Singleton
@Startup
@LocalBean
public class Application {

    boolean running = false;

    @Lock(LockType.READ)
    public boolean  isRunning() {
        return running;
    }


    public void start() {
        running  = true;
    }


    public void stop() {
        running = false;
    }

}
