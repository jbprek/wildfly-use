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
public class TestAsync {
    public static final Logger log = Logger.getLogger(TestAsync.class.getName());

    private static String  result;

    @EJB
    private AsyncBean bean;

    @Test
    @OperateOnDeployment("test-ejb-module-b")
    public void test() throws InterruptedException{
        bean.doWork("Hello");
        Thread.sleep(10);
        Assert.assertEquals("HELLO", result);
    }

    public void observer(@Observes @AsyncBeanDoneEvent String result) {
        log.info("Received Event result ="+result);
        TestAsync.result = result;
    }
}
