package org.bagab.cdi.events;

import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.enterprise.event.Observes;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author prekezes.
 */
@RunWith(Arquillian.class)
public class TestEvent {
    public static final Logger log = Logger.getLogger(TestEvent.class.getName());

    SynchronousQueue<Boolean> waitingQueue = new SynchronousQueue<>();

    @EJB
    private AppControlSingleton bean;

    // TODO Asynchronous checking of the events
    @Test
    @OperateOnDeployment("test-ejb-module-a")
    public void test() {
//        try {
//            Assert.assertTrue(waitingQueue.poll(10000, TimeUnit.MILLISECONDS));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public void observer(@Observes @ApplicationStartedEvent Boolean e) {
        log.info("Received Event");
//        waitingQueue.offer(e);
    }
}
