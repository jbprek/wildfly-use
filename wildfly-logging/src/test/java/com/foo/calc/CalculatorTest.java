package com.foo.calc;

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
public class CalculatorTest {
    @EJB
    private Calculator calculator;

    @Test
    @OperateOnDeployment("test-suite")
    public void testCalculator() throws Exception {
       Assert.assertEquals(2, calculator.add(1,1));
    }
}
