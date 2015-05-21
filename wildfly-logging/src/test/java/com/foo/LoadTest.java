package com.foo;

import com.foo.calc.Calculator;
import com.foo.greet.Greeter;
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

public class LoadTest {

    @EJB
    private Greeter greeterEJB;

    @EJB
    private Calculator calculator;

    @Test
    @OperateOnDeployment("test-suite")
    public void load() throws Exception {
        for (int i = 0; i  < 1000; i++) {
            calculator.add(i, -(i));
            greeterEJB.sayHello("+i");
        }

    }


}
