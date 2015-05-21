package com.foo.greet;

import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

/**
 * @author prekezes.
 */
@RunWith(Arquillian.class)
public class GreeterTest {
    @EJB
    private Greeter greeterEJB;

    @Test
    @OperateOnDeployment("test-suite")
    public void testGreeter() throws Exception {
        String name = "World!";
        Assert.assertEquals("Hello " + name, greeterEJB.sayHello(name));
    }
}
