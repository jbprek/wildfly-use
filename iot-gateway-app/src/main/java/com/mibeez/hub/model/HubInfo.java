package com.mibeez.hub.model;

import java.time.Instant;

/**
 * @author prekezes.
 */
public class HubInfo {
    private String name = "";
    private String wanAddress = "192.168.0.1";
    private HubStatus status = HubStatus.OFF;
    private Instant statusChange = Instant.now();

    private HubInfo() {
        super();
        HubInfo.store();
    }

    private static final HubInfo instance = new HubInfo();

    public static HubInfo getInstance() {
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWanAddress() {
        return wanAddress;
    }

    public void setWanAddress(String wanAddress) {
        this.wanAddress = wanAddress;
    }

    public HubStatus getStatus() {
        return status;
    }

    public void setStatus(HubStatus status) {
        this.status = status;
    }

    public Instant getStatusChange() {
        return statusChange;
    }

    public void setStatusChange(Instant statusChange) {
        this.statusChange = statusChange;
    }


    public static void load() {

    }

    public static void store() {

    }

}
