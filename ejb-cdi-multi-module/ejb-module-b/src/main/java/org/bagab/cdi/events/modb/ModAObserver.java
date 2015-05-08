package org.bagab.cdi.events.modb;

import org.bagab.cdi.events.moda.AppControlSingleton;
import org.bagab.cdi.events.moda.ApplicationChangedStatusEvent;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import java.util.logging.Logger;

/**
 * @author prekezes.
 */
@Singleton
public class ModAObserver {
    public static final Logger log = Logger.getLogger(ModAObserver.class.getName());

    private AppControlSingleton.Status status;

    public void observer(@Observes @ApplicationChangedStatusEvent AppControlSingleton.Status e) {
        status = e;
    }

    public AppControlSingleton.Status getStatus() {
        return status;
    }


}
