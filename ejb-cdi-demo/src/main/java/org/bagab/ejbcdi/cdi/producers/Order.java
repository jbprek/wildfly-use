package org.bagab.ejbcdi.cdi.producers;

/**
 * @author prekezes.
 */
public class Order {

    private Customer customer;

    private double value;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
