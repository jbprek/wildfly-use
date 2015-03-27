package org.bagab.interceptors.cdi;

import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Application lifecycle, Global scope
 */
@Singleton
@Startup
@LocalBean
public class Application {

    private boolean started = false;

    @Lock(LockType.READ)
    public boolean  isStarted() {
        return started;
    }


    public void start() {
        started  = true;
    }


    public void stop() {
        started = false;
    }

}
