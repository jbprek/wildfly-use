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
public class CounterTest {

    @EJB
    private Counter bean;

    @Test
    @OperateOnDeployment("template-ejb-module-simple")
    public void testCounter() throws Exception {
        bean.inc(1);
        bean.inc(2);
        assertEquals(3, bean.getCount());
    }

}
