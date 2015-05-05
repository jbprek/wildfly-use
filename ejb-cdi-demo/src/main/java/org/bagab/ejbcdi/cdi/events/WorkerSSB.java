package org.bagab.ejbcdi.cdi.events;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @author prekezes.
 */
@Stateless
public class WorkerSSB {

    private static Logger log = Logger.getLogger(WorkerSSB.class.getName());

    @Inject
    @WorkDoneEvent
    private Event<String> notifier;

    public void onAppStart(@Observes @ApplicationStartedEvent Void v) {
        log.info("ApplicationStartedEvent reveived!");
    }

    public void proceedToWork(@Observes @WorkToDoEvent String work) {
        Objects.nonNull(work);
        log.info("About to fire WorkToDoEvent!");
        notifier.fire(work.toUpperCase());
        log.info("Fired WorkToDoEvent!");
    }
}
