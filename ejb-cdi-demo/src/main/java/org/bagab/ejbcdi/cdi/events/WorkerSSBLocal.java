package org.bagab.ejbcdi.cdi.events;

import javax.ejb.Local;
import javax.enterprise.event.Observes;

/**
 * @author prekezes.
 */
@Local
public interface WorkerSSBLocal {

    void onAppStart(Boolean v);
    void proceedToWork(String work);
}
