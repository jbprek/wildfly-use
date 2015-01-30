package org.bagab.timers.wapp.control;

import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * @author prekezes.
 */
@RunWith(Arquillian.class)
public class GreeterTest {
    @Inject
    Greeter greeter;

    @Test
    @OperateOnDeployment("test-suite")
    public void testGetMessage() throws Exception {
        String name = "World!";
        greeter.setName(name);

        assertEquals("Hello " + name, greeter.getMessage());
    }
}
