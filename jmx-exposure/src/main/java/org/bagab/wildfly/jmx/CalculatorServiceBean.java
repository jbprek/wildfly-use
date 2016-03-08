package org.bagab.wildfly.jmx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author prekezes.
 */
@Singleton
@Startup
public class CalculatorServiceBean extends AbstractComponentMBean implements ICalculatorServiceMBean {
    public static Logger log = LoggerFactory.getLogger(CalculatorServiceBean.class);


    public CalculatorServiceBean() {
        super("bagab-wildfly-jmx");
    }

    @PostConstruct
    public void setup() {
        log.info("Service started!");
    }


    @PreDestroy
    public void tearDown() {
        log.info("Service stopped!");
    }

    @Override
    public double add(double arg1, double arg2) {
        return arg1 + arg2;
    }

    @Override
    public double substract(double arg1, double arg2) {
        return arg1 - arg2;
    }

    @Override
    public double multiply(double arg1, double arg2) {
        return arg1 * arg2;
    }

    @Override
    public double divide(double arg1, double arg2) {
        return arg1 / arg2;
    }
}
