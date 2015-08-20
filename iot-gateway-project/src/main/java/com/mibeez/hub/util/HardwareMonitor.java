package com.mibeez.hub.util;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Provides hardware discovery and monitoring issues
 *   TODO Implement actual is mock
 * @author prekezes.
 */
@Singleton
@Startup
public class HardwareMonitor {


    public InetAddress getWanAddress() {
        try {
            return InetAddress.getByName("192.168.0.1");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getLanAddress() {
        return "1";
    }
}
