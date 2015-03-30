package org.bagab.ejbcdi;

import org.bagab.ejbcdi.interceptors.Application;
import org.bagab.ejbcdi.interceptors.BusinesComponent;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * @author prekezes.
 */
@RunWith(Arquillian.class)
public class Test {

    @Inject
    private Application application;

    @Inject
    private BusinesComponent businesComponent;

    /**
     * Both busines methods must run when application isStarted
     */
    @org.junit.Test
    @OperateOnDeployment("test-suite")
    @InSequence(1)
    public void testStarted() {
        application.start();
        assertTrue(application.isStarted());
        assertEquals(0, businesComponent.aBusinesMethod(1));
        assertEquals(1, businesComponent.anotherBusinesMethod(1));
    }

    /**
     * businesComponent.aBusinesMethod must run with Application started or not
     */
    @org.junit.Test
    @OperateOnDeployment("test-suite")
    @InSequence(2)
    public void testStopedOk() {
        application.start();
        assertTrue(application.isStarted());
        assertEquals(0, businesComponent.aBusinesMethod(1));
        application.start();
        assertEquals(0, businesComponent.aBusinesMethod(1));
    }

    /**
     * businesComponent.anotherBusinesMethod must run only with Application started.
     */
    @org.junit.Test
    @OperateOnDeployment("test-suite")
    @InSequence(3)
    public void testStopedException() {
        application.start();
        assertTrue(application.isStarted());
        assertEquals(1, businesComponent.anotherBusinesMethod(1));

        application.stop();
        assertTrue(!application.isStarted());
        System.out.println("####" + businesComponent.anotherBusinesMethod(1));
    }

}
