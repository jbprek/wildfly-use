package org.bagab.ejbcdi.cdi.producers;

import javax.inject.Inject;

/**
 * @author prekezes.
 */
public class Customer {

    private String name;

    public Customer() {
    }

    @Inject
    public Customer(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
