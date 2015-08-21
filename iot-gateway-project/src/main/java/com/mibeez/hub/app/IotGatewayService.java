package com.mibeez.hub.app;

import com.mibeez.hub.model.SensorType;
import com.mibeez.hub.to.HubInfo;
import com.mibeez.hub.to.SensorInfo;

import javax.ejb.Local;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;

/**
 * @author prekezes.
 */
@Local
public interface IotGatewayService {

    // -------- Incoming messages ---------

    HubInfo getHubInfo();

    void commitHub(String name) throws HubGatewayException;

    void disableHub() throws HubGatewayException;

    void setStandby(boolean standby) throws HubGatewayException;

    void onHiveDetected(String lanAddress) throws HubGatewayException;

    void disableHive(String lanAddress) throws HubGatewayException;


    /**
     * Get List of Hive lan addresses
     */
    List<String> alHives();

    /*
     * Get values of sensors on Hive
     */
    List<SensorInfo> getHiveSensorValues(String lanAddress) throws HubGatewayException;


    /*
     * Get values of sensors on Hive
     */
    List<SensorInfo> allHiveSensorValues(String lanAddress) throws HubGatewayException;


    //-------- Outgoing Messages ------------------

    /*
    	CS	HUB	PUT	/connect/{:unique_factory_id}		Periodically sent from uncommissioned Hubs	None
	CS	HUB	PUT	/hub/{:name}/new_wan_address		Notification that wan_address has changed for a hub, or that the hub requests to be re-commissioned after a a temporay decommission	None
	CS	HUB	POST	/hub/{:name}/alerts		Notification for  alarms from Hub to CS	POST SensorInfo[]
	CS	HUB	POST	/hub/{:name}/warnings		Notification for  warnings from Hub to CS	POST SensorInfo[]
	CS	HUB	POST	/hub/{:name}/new_cell/{:lan_address}		Notification that a new hive was introduced	POST CellInfo

     */


    boolean askCommissioning(String uniqueId);

    boolean newWanAddressEvent(InetAddress wanAddress);

    boolean newHiveEvent(String lan_address);

    boolean alertsEvent(List<SensorInfo> alerts);







}
