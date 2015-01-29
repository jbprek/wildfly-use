package org.bagab.wapp.control;

import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import static org.junit.Assert.assertEquals;

/**
 * @author prekezes.
 */
@RunWith(Arquillian.class)
public class GreeterEJBTest {
    @EJB
    private GreeterEJB greeterEJB;

    @Test
    @OperateOnDeployment("test-suite")
    public void testGreeter() throws Exception {
        String name = "World!";
        assertEquals("Hello " + name, greeterEJB.sayHello(name));
    }
}
