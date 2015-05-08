package org.bagab.cdi.events.moda;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * @author prekezes.
 */
@Singleton
@Startup
public class AppControlSingleton {
    private static Logger log = Logger.getLogger(AppControlSingleton.class.getName());

    public enum Status { STARTED, STOPPED };

    private Status status;

    @Inject
    @ApplicationChangedStatusEvent
    private Event<Status> changedStatusNotifier;

    public void start() {
        status = status.STARTED;
        changedStatusNotifier.fire(Status.STARTED);
    }


    public void stop() {
        status = status.STOPPED;
        changedStatusNotifier.fire(Status.STOPPED);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
