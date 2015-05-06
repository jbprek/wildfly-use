package org.bagab.ejbcdi.cdi.events;

import org.bagab.ejbcdi.cdi.events.AppControlSingleton;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

/**
 * Created by x on 5/6/15.
 */

@RunWith(Arquillian.class)
public class EventsTest {

    @EJB
    private AppControlSingleton bean;

    @Test
    @OperateOnDeployment("test-events")
    public void test() {
        bean.doWork("hello");
    }
}
