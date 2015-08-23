package com.mibeez.hub.app;

import com.mibeez.hub.model.HubStatus;
import com.mibeez.hub.model.LanAddress;
import com.mibeez.hub.model.SensorValue;
import redis.clients.jedis.Jedis;

import javax.ejb.Stateless;
import java.net.InetAddress;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author prekezes.
 */
@Stateless
public class IotGatewayService {

    private static final Logger log = Logger.getGlobal();


    /* Detected in the underlying hardware */
    private InetAddress wanAddress;
    /* Detected in the underlying hardware */
    private String lanAddress;
    /* Status */
    private HubStatus status = HubStatus.OFF;
    /* Status modification time */
    private Date statusUpdate = new Date();
    /* Assigned from central system */
    private String name;
    /* Factory assigned - globally unique*/
    private String uniqueId;
    /* Factory assigned - Central's system base URI */
    private URI centralSystemURI;

    private Jedis jedis = new Jedis("localhost");

    /**
     * Information about Hub hardware and status
     */



    public Map<LanAddress, List<SensorValue>> getAllSensorValues() throws IotGatewayException {
        return null;
    }

    /**
     * Evict all cached sensor values, fetch and cache new ones
     *
     * @return
     */

    public Map<LanAddress, List<SensorValue>> refreshAndGetAllSensorValues() throws IotGatewayException {
        return null;
    }

    /**
     * Cell cached sensor values
     *
     * @param cell
     * @return
     */

    public List<SensorValue> getCellSensorValues(LanAddress cell) throws IotGatewayException {
        return null;
    }

    /**
     * Evict all cached sensor values for a given cell, fetch and cache new ones
     *
     * @param cell
     * @return
     */

    public List<SensorValue> refreshAndGetCellSensorValues(LanAddress cell) throws IotGatewayException {
        return null;
    }


    public void onAlertEvent(LanAddress address, SensorValue sensorValue) throws IotGatewayException {

    }



    public void onHiveDetected(LanAddress lanAddress) throws IotGatewayException {

    }


    public void disableHive(LanAddress lanAddress) throws IotGatewayException {

    }


    public boolean askCommissioning(String uniqueId) {
        return false;
    }


    public boolean newWanAddressEvent(InetAddress wanAddress) {
        return false;
    }


    public boolean newHiveEvent(String lan_address) {
        return false;
    }
}
