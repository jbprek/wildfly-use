package org.bagab.cdi.events;

import org.bagab.cdi.events.moda.AppControlSingleton;
import org.bagab.cdi.events.moda.ApplicationChangedStatusEvent;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.enterprise.event.Observes;
import java.util.concurrent.SynchronousQueue;
import java.util.logging.Logger;

/**
 * @author prekezes.
 */
@RunWith(Arquillian.class)
public class TestEvent {
    public static final Logger log = Logger.getLogger(TestEvent.class.getName());


    public static boolean appStarted = false;
    public static boolean appStopped = false;

    @EJB
    private AppControlSingleton bean;

    // TODO Asynchronous checking of the events
    @Test
    @OperateOnDeployment("test-ejb-module-a")
    public void test() {
        bean.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bean.stop();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(true, TestEvent.appStarted);
        Assert.assertEquals(true, TestEvent.appStopped);

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
