package org.bagab.ejbmod;

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
public class HelloTest {
    @EJB
    private Hello simpleStatelessEJB;

    @Test
    @OperateOnDeployment("test-stateless")
    public void testGreeter() throws Exception {
        String name = "World!";
        assertEquals("Hello " + name, simpleStatelessEJB.sayHello(name));
    }

    // TODO add remote interface test with a
}
