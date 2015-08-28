package com.mibeez.hub.app;

import com.mibeez.hub.model.HubInfo;
import com.mibeez.hub.model.LanAddress;
import com.mibeez.hub.model.SensorType;
import com.mibeez.hub.model.SensorValue;
import sun.management.Sensor;

import javax.ejb.Local;
import java.util.Map;

/**
 * @author prekezes.
 */
@Local
public interface HubDAO {

    /**
     * Called on application startup when hub is not commissioned
     * @throws IotGatewayException
     */
    void hubInit()  throws IotGatewayException;

    /*
     * Returns hub info
     * @throws IotGatewayException
     */
    HubInfo getHubInfo() throws IotGatewayException;

    /**
     * Commission Hub with name provided from the Central system
     * @param name
     * @throws IotGatewayException
     */
    void hubCommission(String name) throws IotGatewayException;

    /**
     * Toggle Hub to standby or to ON mode
     * @param standby
     * @throws IotGatewayException
     */
    void hubToggleStandBy(boolean standby) throws IotGatewayException;

    /**
     * Get all sensor values
     * @return
     * @throws IotGatewayException
     */
    Map<LanAddress, Map<SensorType, SensorValue>> getSensorValues() throws IotGatewayException;

    /**
     * Get all stored sensor values for a specific LAN address
     * @param lanAddress
     * @return
     * @throws IotGatewayException
     */
    Map<SensorType, SensorValue>  getSensorValues(LanAddress lanAddress) throws IotGatewayException;

    /**
     * Get  stored sensor value for a specific LAN address
     * @param lanAddress
     * @return
     * @throws IotGatewayException
     */
    Map<SensorType, SensorValue>  getSensorValues(LanAddress lanAddress, SensorType sensorType) throws IotGatewayException;

    /**
     * Refresh all sensor values
     * @throws IotGatewayException
     */
    void refreshSensorValues() throws IotGatewayException;

    /**
     * Refresh all stored sensor values for a specific LAN address
     * @param lanAddress
     * @return
     * @throws IotGatewayException
     */
    void refreshSensorValues(LanAddress lanAddress) throws IotGatewayException;

    /**
     * get Alert conditions
     * @return
     * @throws IotGatewayException
     */
    Map<LanAddress, Map<SensorType, SensorValue>> getAlerts() throws IotGatewayException;

    /**
     * Notification for new values triggered by Sensor incoming command
     * @param address
     * @param values
     * @throws IotGatewayException
     */
    void onValuesEvent(LanAddress address, Map<SensorType, SensorValue> values) throws IotGatewayException;



}
