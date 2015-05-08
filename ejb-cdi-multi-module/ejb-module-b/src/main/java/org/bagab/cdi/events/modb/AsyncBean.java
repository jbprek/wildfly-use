package org.bagab.cdi.events.modb;

import org.bagab.cdi.events.moda.ApplicationChangedStatusEvent;

import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.Objects;

/**
 * @author prekezes.
 */
@Singleton
public class AsyncBean {

    @Inject
    @AsyncBeanDoneEvent
    private Event<String> completionNotifier;

    /**
     * This is not an appropriate use, Events are better for broadcasting.
     *  A future would be more appropriate in this case
     * @param payload
     */
    @Asynchronous
    public void doWork(String payload) {
        Objects.requireNonNull(payload);
        completionNotifier.fire(payload.toUpperCase());
    }
}
