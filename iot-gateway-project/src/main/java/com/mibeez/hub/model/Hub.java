package com.mibeez.hub.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author prekezes.
 */
public class Hub implements Serializable{

    /* Operating parameters */
    private HubInfo parameters;
    /* Sensors controlled the hub */
    private Map<LanAddress, Map<SensorType, SensorValue>> sensorUnits = new HashMap<>();

    public HubInfo getParameters() {
        return parameters;
    }

    public void setParameters(HubInfo parameters) {
        this.parameters = parameters;
    }

    public Map<LanAddress, Map<SensorType, SensorValue>> getSensorUnits() {
        return sensorUnits;
    }

    public void setSensorUnits(Map<LanAddress, Map<SensorType, SensorValue>> sensorUnits) {
        this.sensorUnits = sensorUnits;
    }
}
