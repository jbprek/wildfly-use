package com.mibeez.hub.to;

import com.mibeez.hub.model.SensorType;

/**
 * @author prekezes.
 */
public class SensorIdInfo {
    private String lanAddress;
    private SensorType sensorType;

    public String getLanAddress() {
        return lanAddress;
    }

    public void setLanAddress(String lanAddress) {
        this.lanAddress = lanAddress;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }
}
