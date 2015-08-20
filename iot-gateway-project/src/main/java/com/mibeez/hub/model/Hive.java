package com.mibeez.hub.model;

import java.net.InetAddress;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author prekezes.
 */
public class Hive {

    /* Detected in the underlying hardware */
    private String lanAddress;
    private Map<SensorType, String> mapValues = new EnumMap<>(SensorType.class);

    public String getLanAddress() {
        return lanAddress;
    }

    public void setLanAddress(String lanAddress) {
        this.lanAddress = lanAddress;
    }

    public Map<SensorType, String> getMapValues() {
        return mapValues;
    }

    public void setMapValues(Map<SensorType, String> mapValues) {
        this.mapValues = mapValues;
    }

    private String getSensorValue(SensorType sensorType) {
        return mapValues.get(sensorType);
    }

    private void setSensorType(SensorType sensorType, String value) {
        mapValues.put(sensorType, value);
    }
}
