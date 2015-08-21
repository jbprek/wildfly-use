package com.mibeez.hub.app;

import com.mibeez.hub.to.HubInfo;
import com.mibeez.hub.to.SensorInfo;

import javax.ejb.Stateless;
import java.net.InetAddress;
import java.util.List;

/**
 * @author prekezes.
 */
@Stateless
public class IotGatewayServiceBean implements IotGatewayService {
    @Override
    public HubInfo getHubInfo() {
        return null;
    }

    @Override
    public void commitHub(String name) throws HubGatewayException {

    }

    @Override
    public void disableHub() throws HubGatewayException {

    }

    @Override
    public void setStandby(boolean standby) throws HubGatewayException {

    }

    @Override
    public void onHiveDetected(String lanAddress) throws HubGatewayException {

    }

    @Override
    public void disableHive(String lanAddress) throws HubGatewayException {

    }

    @Override
    public List<String> alHives() {
        return null;
    }

    @Override
    public List<SensorInfo> getHiveSensorValues(String lanAddress) throws HubGatewayException {
        return null;
    }

    @Override
    public List<SensorInfo> allHiveSensorValues(String lanAddress) throws HubGatewayException {
        return null;
    }

    @Override
    public boolean askCommissioning(String uniqueId) {
        return false;
    }

    @Override
    public boolean newWanAddressEvent(InetAddress wanAddress) {
        return false;
    }

    @Override
    public boolean newHiveEvent(String lan_address) {
        return false;
    }

    @Override
    public boolean alertsEvent(List<SensorInfo> alerts) {
        return false;
    }
}
