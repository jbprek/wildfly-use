package org.bagab.wildfly.jmx;

import javax.management.MXBean;

/**
 * @author prekezes.
 */
@MXBean
public interface ICalculatorServiceMBean {
    double add(double arg1, double arg2);

    double substract(double arg1, double arg2);

    double multiply(double arg1, double arg2);

    double divide(double arg1, double arg2);
}
