package com.mibeez.hub.model;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Each cell is
 */
public class Cell implements Serializable {

    /* Detected in the underlying hardware */
    private LanAddress lanAddress;

    private List<SensorValue> sensorValues = new ArrayList<>();

    private Map<SensorType, SensorValue> sensors = new EnumMap<>(SensorType.class);

    public LanAddress getLanAddress() {
        return lanAddress;
    }

    public void setLanAddress(LanAddress lanAddress) {
        this.lanAddress = lanAddress;
    }

    public List<SensorValue> getSensorValues() {
        return sensorValues;
    }

    public void setSensorValues(List<SensorValue> sensorValues) {
        this.sensorValues = sensorValues;
    }

    public Map<SensorType, SensorValue> getSensors() {
        return sensors;
    }

    public void setSensors(Map<SensorType, SensorValue> sensors) {
        this.sensors = sensors;
    }
}
