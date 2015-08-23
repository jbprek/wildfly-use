package com.mibeez.hub.to;

/**
 * Created by john on 8/23/15.
 */
public class HubTO {
    /* Constants to be used both as REDIS keys and json tags */
    public static final String HUB_INFO_KEY = "hub_info";

    public static final String PARAMETERS_KEYs = "params";

    private HubParametersTO params;

    public HubParametersTO getParams() {
        return params;
    }
}
