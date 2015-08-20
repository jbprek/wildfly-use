package com.mibeez.hub.to;

import com.mibeez.hub.model.HubStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author prekezes.
 */
public class HubInfo {
    private String name = "";
    private String wanAddress = "192.168.0.1";
    private HubStatus status = HubStatus.OFF;
    private Date statusUpdate = new Date();

    public static HubInfo valueOf(Map<String, String> map) {
        HubInfo h = new HubInfo();
        h.setName(map.get("name"));
        h.setWanAddress(map.get("wan_address"));
        h.setStatus(HubStatus.valueOf(map.get("status")));
        return h;
    }

    public Map<String, String> toMap() {
        Map<String, String> m = new HashMap<>();
        m.put("name", this.getName());
        m.put("wan_address", this.getWanAddress());
        m.put("status", this.getStatus().name());
        return m;
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

    @Override
    public String toString() {
        return "HubInfo{" +
                "name='" + name + '\'' +
                ", wanAddress='" + wanAddress + '\'' +
                ", status=" + status +
                '}';
    }
}
