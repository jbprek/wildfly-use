package com.mibeez.hub.model;

import java.net.InetAddress;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author prekezes.
 */
public class Hub {

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

    /* Hives attached to the hub */
    Map<String, Hive> hives = new HashMap<>();

    public Hub() {
    }

    public Hub(InetAddress wanAddress, String lanAddress, String uniqueId, URI centralSystemURI) {
        this.wanAddress = wanAddress;
        this.lanAddress = lanAddress;
        this.uniqueId = uniqueId;
        this.centralSystemURI = centralSystemURI;
    }

    public InetAddress getWanAddress() {
        return wanAddress;
    }

    public void setWanAddress(InetAddress wanAddress) {
        this.wanAddress = wanAddress;
    }

    public String getLanAddress() {
        return lanAddress;
    }

    public void setLanAddress(String lanAddress) {
        this.lanAddress = lanAddress;
    }

    public HubStatus getStatus() {
        return status;
    }

    public void setStatus(HubStatus status) {
        this.status = status;
    }

    public Date getStatusUpdate() {
        return statusUpdate;
    }

    public void setStatusUpdate(Date statusUpdate) {
        this.statusUpdate = statusUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public URI getCentralSystemURI() {
        return centralSystemURI;
    }

    public void setCentralSystemURI(URI centralSystemURI) {
        this.centralSystemURI = centralSystemURI;
    }
}
