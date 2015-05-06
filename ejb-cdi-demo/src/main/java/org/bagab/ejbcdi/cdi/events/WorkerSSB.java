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

    public void onAppStart(@Observes @ApplicationStartedEvent Boolean v) {
        log.info("ApplicationStartedEvent reveived!");
    }

    public void proceedToWork(@Observes @WorkToDoEvent String work) {
        log.info("WorkToDoEvent received - , request:" + work);
        Objects.nonNull(work);
        log.info("WorkDoneEvent sending !");
        notifier.fire(work.toUpperCase());
        log.info("WorkDoneEvent sent!");
    }
}
