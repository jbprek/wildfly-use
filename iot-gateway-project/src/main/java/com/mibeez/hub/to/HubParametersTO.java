package com.mibeez.hub.to;

import com.mibeez.hub.model.Hub;
import com.mibeez.hub.model.HubParameters;
import com.mibeez.hub.model.HubStatus;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Transfer object for HubParameters
 */
public class HubParametersTO {

    /* Constants to be used both as REDIS keys and json tags */

    //Key tag
    public static final String HUB_PARAMETERS_KEY = "hub_params";
    // Field tags
    public static final String WAN_ADDRESS_KEY = "wan_ifce";
    public static final String LAN_ADDRESS_KEY = "lan_address";
    public static final String STATUS_KEY = "status";
    public static final String STATUS_UPDATE_KEY = "status_update";
    public static final String UNIQUE_ID_KEY = "uid";
    public static final String CENTRAL_SYSTEM_URI_KEY = "cs_uri";
    public static final String VERSION_KEY = "version";
    public static final String NAME_KEY = "name";

    /* Detected in the underlying hardware */
    // @NotNull
    private final String wanInterface;
    /* Detected in the underlying hardware */
    // @NotNull
    private final String lanAddress;
    /* Status */
    // @NotNull
    private final String status;
    /* Status modification time */
    // @NotNull
    private final String statusUpdate;
    /* Assigned from central system */
    private final String name;
    /* Factory assigned - globally unique*/
    // @NotNull
    private final String uniqueId;
    /* Factory assigned - Central's system base URI */
    // @NotNull
    private final String centralSystemURI;
    /* Hub version */
    // @NotNull
    private final String version;

    /**
     * Default constructor
     *
     * @param wanInterface
     * @param lanAddress
     * @param status
     * @param statusUpdate
     * @param uniqueId
     * @param centralSystemURI
     * @param version
     * @param name
     */
    public HubParametersTO(String wanInterface, String lanAddress, String status, String statusUpdate, String uniqueId, String centralSystemURI, String version, String name) {
        Objects.nonNull(wanInterface);
        Objects.nonNull(lanAddress);
        Objects.nonNull(status);
        Objects.nonNull(statusUpdate);
        Objects.nonNull(uniqueId);
        Objects.nonNull(centralSystemURI);
        Objects.nonNull(version);
        this.wanInterface = wanInterface;
        this.lanAddress = lanAddress;
        this.status = status;
        this.statusUpdate = statusUpdate;
        this.name = name;
        this.uniqueId = uniqueId;
        this.centralSystemURI = centralSystemURI;
        this.version = version;
    }

    /**
     * Static factory - Convert TO to model class
     */
    public HubParameters toHubParameters() {
        HubParameters h = new HubParameters(wanInterface, lanAddress, HubStatus.valueOf(status), null, uniqueId, URI.create(centralSystemURI), version);
        h.setName(name);
        return h;
    }


    /**
     * Static factory - Create from model class
     */
    public static HubParametersTO valueOf(HubParameters hub) {
        Objects.nonNull(hub);
        return new HubParametersTO(hub.getWanInterface(), hub.getLanAddress(), hub.getStatus().name(), null,
                hub.getUniqueId(), hub.getCentralSystemURI().toString(), hub.getVersion(), hub.getName());
    }

    /**
     * Factory - create from REDIS output
     *
     * @param map
     * @return
     */
    public static HubParametersTO valueOf(Map<String, String> map) {
        Objects.nonNull(map);
        String wanInterface = map.get(WAN_ADDRESS_KEY);
        String lanAddress = map.get(LAN_ADDRESS_KEY);
        String status = map.get(STATUS_KEY);
        String statusUpdate = map.get(STATUS_UPDATE_KEY);
        String uniqueId = map.get(UNIQUE_ID_KEY);
        String centralSystemURI = map.get(CENTRAL_SYSTEM_URI_KEY);
        String version = map.get(VERSION_KEY);
        String name = map.get(NAME_KEY);
        HubParametersTO to = new HubParametersTO(wanInterface, lanAddress, status, statusUpdate, uniqueId, centralSystemURI, version, name);
        return to;
    }

    /**
     * Convert to form appropriate for REDIS store
     */
    public Map<String, String> toMap() {
        Map<String, String> m = new HashMap<>();
        m.put(WAN_ADDRESS_KEY, wanInterface);
        m.put(LAN_ADDRESS_KEY, lanAddress);
        m.put(STATUS_KEY, status);
        m.put(STATUS_UPDATE_KEY, statusUpdate);
        m.put(UNIQUE_ID_KEY, uniqueId);
        m.put(CENTRAL_SYSTEM_URI_KEY, centralSystemURI);
        m.put(VERSION_KEY, version);
        m.put(NAME_KEY, name);
        return m;
    }

    public String getWanInterface() {
        return wanInterface;
    }

    public String getLanAddress() {
        return lanAddress;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusUpdate() {
        return statusUpdate;
    }

    public String getName() {
        return name;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getCentralSystemURI() {
        return centralSystemURI;
    }

    public String getVersion() {
        return version;
    }

}
