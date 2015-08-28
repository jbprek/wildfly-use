package com.mibeez.hub.model;

/**
 * @author prekezes.
 */
public class ToggleStandbyPutData {
    private final boolean standby;

    public ToggleStandbyPutData(boolean standby) {
        this.standby = standby;
    }

    public boolean isStandby() {
        return standby;
    }
}
