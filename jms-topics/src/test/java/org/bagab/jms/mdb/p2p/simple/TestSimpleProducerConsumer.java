package org.bagab.jms.mdb.p2p.simple;

import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

/**
 * @author prekezes.
 */
@RunWith(Arquillian.class)
public class TestSimpleProducerConsumer {

    @EJB
    private SimpleMessageProducer producer;

    @Test
    @OperateOnDeployment("test-suite")
    public void test() throws Exception {
        producer.sendMessage("Hello");
    }
}
