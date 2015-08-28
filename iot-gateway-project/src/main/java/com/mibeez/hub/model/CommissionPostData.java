package com.mibeez.hub.model;

/**
 * Post data for {@link com.mibeez.hub.app.HubServiceRest#commission(String)}
 */
public class CommissionPostData {
    private final String name;

    public CommissionPostData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
