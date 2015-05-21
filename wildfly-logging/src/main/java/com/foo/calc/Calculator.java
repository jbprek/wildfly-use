package com.foo.calc;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

import org.apache.log4j.*;

/**
 * @author prekezes.
 */

@Stateless
public class Calculator {
    private static final Logger log = Logger.getLogger(Calculator.class);

    @PostConstruct
    private void setup() {
        log.info("LOG4J instance created!");
    }

    @PreDestroy
    private void teadown() {
        log.info("LOG4J instance destroyed!");
    }

    public long add(long a, long b) {
        log.info("LOG4J requested addition " + a + "+" + b + "=" + (a + b));
        return a + b;
    }
}
