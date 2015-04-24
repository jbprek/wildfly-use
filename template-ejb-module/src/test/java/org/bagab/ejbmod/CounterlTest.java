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
public class CounterlTest {

    // TODO Replace with separate lookups of
    @EJB
    private Counter bean;

    @Test
    @OperateOnDeployment("test-stateful")
    public void testCounter() throws Exception {
        bean.inc(1);
        bean.inc(2);
        assertEquals(3, bean.getCount());
    }

    // TODO add remote interface test with a
}
