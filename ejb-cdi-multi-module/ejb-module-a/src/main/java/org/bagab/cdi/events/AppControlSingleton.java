package org.bagab.cdi.events;

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


    /**
     * Fires ApplicationStartedEvent event
     */
    @PostConstruct
    private void setup() {
        log.info("ApplicationStartedEvent sending!");
        startupNotifier.fire(Boolean.TRUE);
        log.info("ApplicationStartedEvent sent!");

    }


}
