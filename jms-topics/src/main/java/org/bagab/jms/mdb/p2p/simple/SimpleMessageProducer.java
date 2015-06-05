package org.bagab.jms.mdb.p2p.simple;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 * @author prekezes.
 */

@Stateless
public class SimpleMessageProducer {
    @Inject
    private JMSContext context;

    @Resource(lookup = "java:/queue/SimpleQueue")
    private Queue queue;

    public void sendMessage(String message) {
        final Destination destination = queue;
        context.createProducer().send(destination, message);
    }

}
