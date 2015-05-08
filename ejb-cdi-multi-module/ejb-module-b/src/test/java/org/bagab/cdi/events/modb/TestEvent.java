package org.bagab.cdi.events.modb;

import org.bagab.cdi.events.moda.AppControlSingleton;
import org.bagab.cdi.events.moda.ApplicationChangedStatusEvent;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.enterprise.event.Observes;
import java.util.logging.Logger;

/**
 * @author prekezes.
 */
@RunWith(Arquillian.class)
public class TestEvent {
    public static final Logger log = Logger.getLogger(TestEvent.class.getName());

    private boolean appStarted = false;
    private boolean appStopped = false;

    @EJB
    private AppControlSingleton modAObservable;

    @EJB
    private ModAObserver observerInModB;

    // TODO Asynchronous checking of the events
    @Test
    @OperateOnDeployment("test-ejb-module-b")
    public void test() {
        modAObservable.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(AppControlSingleton.Status.STARTED, modAObservable.getStatus());
        Assert.assertEquals(AppControlSingleton.Status.STARTED, observerInModB.getStatus());


        modAObservable.stop();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(AppControlSingleton.Status.STOPPED, modAObservable.getStatus());
        Assert.assertEquals(AppControlSingleton.Status.STOPPED, observerInModB.getStatus());

    }

    public void observer(@Observes @ApplicationChangedStatusEvent AppControlSingleton.Status e) {
        log.info("Received Event");
        switch (e) {
            case  STARTED:
                appStarted = true;
                break;
            case STOPPED:
                appStopped = true;
        }
        ;
    }
}
