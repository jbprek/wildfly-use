package com.mibeez.hub.model;

import java.net.URI;
import java.time.Instant;

/**
 * Hub Operating Parameters.
 */
public class HubInfo {
    /* Detected in the underlying hardware */
    private String wanInterface;
    /* Detected in the underlying hardware */
    private String lanAddress;
    /* Status */
    private HubStatus status;
    /* Status modification time */
    private Instant statusUpdate;
    /* Factory assigned - globally unique*/
    private String uniqueId;
    /* Factory assigned - Central's system base URI */
    private URI centralSystemURI;
    /* Hub version */
    private String version;
    /* Assigned from central system */
    private String name;

    public HubInfo(String wanInterface, String lanAddress, HubStatus status, Instant statusUpdate, String uniqueId, URI centralSystemURI, String version) {
        this.wanInterface = wanInterface;
        this.lanAddress = lanAddress;
        this.status = status;
        this.statusUpdate = statusUpdate;
        this.uniqueId = uniqueId;
        this.centralSystemURI = centralSystemURI;
        this.version = version;
    }

    public String getWanInterface() {
        return wanInterface;
    }

    public void setWanInterface(String wanInterface) {
        this.wanInterface = wanInterface;
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

    public Instant getStatusUpdate() {
        return statusUpdate;
    }

    public void setStatusUpdate(Instant statusUpdate) {
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
