package org.bagab.ee7.test;

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
public class LocalEJBTest {
    @EJB
    private LocalEJB localEJB;

    @Test
    @OperateOnDeployment("test-suite")
    public void testGreeter() throws Exception {
        String name = "World!";
        assertEquals("Hello " + name, localEJB.sayHello(name));
    }
}
