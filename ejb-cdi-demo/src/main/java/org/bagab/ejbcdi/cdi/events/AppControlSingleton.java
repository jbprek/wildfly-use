package org.bagab.ejbcdi.cdi.events;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * @author prekezes.
 */
@Singleton
@Startup
public class AppControlSingleton {
    private static Logger log = Logger.getLogger(AppControlSingleton.class.getName());

    @Inject
    @ApplicationStartedEvent
    private Event<Void> startupNotifier;

    @Inject
    @WorkToDoEvent
    private Event<String> proceedNotifier;

    /**
     * Fires ApplicationStartedEvent event
     */
    @PostConstruct
    private void setup() {
        log.info("About to fire ApplicationStartedEvent!");
        startupNotifier.fire(null);
        log.info("Fired ApplicationStartedEvent!");

    }

    /**
     * Order a (any) worker to proceed, firing the event WorkToDoEvent
     */
    void doWork(String request) {
        log.info("External call with request :" + request + " About to fire OrderToProceedEvent");
        proceedNotifier.fire(request);
        log.info("Fired OrderToProceedEvent!");
    }

    /**
     * Notification from worker that tx is complete
     * @param reply
     */
    void workComplete(@Observes @WorkDoneEvent String reply) {
        log.info("Received reply :" + reply);
    }


}
