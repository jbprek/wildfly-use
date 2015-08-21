package com.mibeez.hub.to;

import java.util.Date;

/**
 * @author prekezes.
 */
public class SensorInfo {

    private SensorIdInfo sensorId;
    private String value;
    private Date measurementTime;

    public SensorIdInfo getSensorId() {
        return sensorId;
    }

    public void setSensorId(SensorIdInfo sensorId) {
        this.sensorId = sensorId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(Date measurementTime) {
        this.measurementTime = measurementTime;
    }
}
