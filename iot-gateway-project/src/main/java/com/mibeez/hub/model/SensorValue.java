package com.mibeez.hub.model;

import java.io.Serializable;
import java.time.Instant;

/**
 * Superclass for the sensor values
 */
public class SensorValue implements Serializable{
    private final SensorType sensorType;
    private final String value;
    private final Instant time;

    public SensorValue(SensorType sensorType, String value, Instant time) {
        this.sensorType = sensorType;
        this.value = value;
        this.time = time;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public String getValue() {
        return value;
    }

    public Instant getTime() {
        return time;
    }
}
