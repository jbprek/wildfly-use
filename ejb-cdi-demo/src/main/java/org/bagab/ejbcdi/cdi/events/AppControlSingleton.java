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
    private Event<Boolean> startupNotifier;

    @Inject
    @WorkToDoEvent
    private Event<String> proceedNotifier;

    /**
     * Fires ApplicationStartedEvent event
     */
    @PostConstruct
    private void setup() {
        log.info("ApplicationStartedEvent sending!");
        startupNotifier.fire(Boolean.TRUE);
        log.info("ApplicationStartedEvent sent!");

    }

    /**
     * Order a (any) worker to proceed, firing the event WorkToDoEvent
     */
    public void doWork(String request) {
        log.info("doWork called, request :" + request );
        log.info("OrderToProceedEvent sending!");
        proceedNotifier.fire(request);
        log.info("OrderToProceedEvent sent!");
    }

    /**
     * Notification from worker that tx is complete
     * @param reply
     */
    public void workComplete(@Observes @WorkDoneEvent String reply) {
        log.info("Received reply :" + reply);
    }


}
