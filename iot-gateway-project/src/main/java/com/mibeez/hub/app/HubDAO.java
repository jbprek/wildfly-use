package com.mibeez.hub.app;

import com.mibeez.hub.model.HubParameters;
import com.mibeez.hub.model.HubStatus;
import com.mibeez.hub.to.HubParametersTO;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import java.net.URI;
import java.time.Instant;
import java.util.Map;
import java.util.logging.Logger;

import static com.mibeez.hub.to.HubParametersTO.*;

/**
 * Only one instance of a hub exists, methods here provide atomicity of operation on HubParameters
 */

@Singleton
public class HubDAO {
    private static final Logger log = Logger.getGlobal();

    private HubParameters parameters;
    private HubParametersTO parametersTO;

    private Jedis jedis = new Jedis("localhost");

    /**
     * On Startup if Hub instance doesn't exist this means that the hub is un-commissioned
     */
    @PostConstruct
    private void setup() throws IotGatewayException {
        log.config("@PostConstruct");
        try {
            if (!jedis.exists(HUB_PARAMETERS_KEY)) {
                parameters = new HubParameters("eth0", "1", HubStatus.OFF, Instant.now(), "ABRA-CADABRA", URI.create("http://localhost:8080/cs"), "0");
                parametersTO = HubParametersTO.valueOf(parameters);
                redisStore();
            }
        } catch (Exception e) {
            log.severe(e.getMessage());
            throw new IotGatewayException("@PostConstruct failed", e);
        }
    }

    /*
     * Only thread safe copy is escaping
     */
    public HubParametersTO getParametersTO() {
        return parametersTO;
    }

    /**
     * CS commissions providing name
     *
     * @param name
     * @throws IotGatewayException
     */
    public void commitHub(String name) throws IotGatewayException {
        try {
            log.config("commitHub Entry");
            parameters.setName(name);
            parameters.setStatus(HubStatus.ON);
            parameters.setStatusUpdate(Instant.now());
            parametersTO = HubParametersTO.valueOf(parameters);
            log.config("commitHub Exit");
            redisStore();
        } catch (Exception e) {
            log.severe(e.getMessage());
            throw new IotGatewayException("commitHub", e);
        }

    }

    /**
     * CS commands Hub decommission
     */
    public void disableHub() throws IotGatewayException {
        try {
            log.config("disableHub Entry");
            parameters.setName(null);
            parameters.setStatus(HubStatus.OFF);
            parameters.setStatusUpdate(Instant.now());
            parametersTO = HubParametersTO.valueOf(parameters);
            log.config("disableHub Exit");
            redisStore();
        } catch (Exception e) {
            log.severe(e.getMessage());
            throw new IotGatewayException("disableHub", e);
        }

    }

    /**
     * Sets or disables standby mode
     *
     * @param standby
     * @throws IotGatewayException
     */
    public void setStandby(boolean standby) throws IotGatewayException {
        try {
            log.config("setStandby Entry");
            parameters.setName(null);
            parameters.setStatus(HubStatus.OFF);
            parameters.setStatusUpdate(Instant.now());
            parametersTO = HubParametersTO.valueOf(parameters);
            log.config("setStandby Exit");
            redisStore();
        } catch (Exception e) {
            log.severe(e.getMessage());
            throw new IotGatewayException("setStandby", e);
        }
    }

    /**
     * Fetches from REDIS hub parameters
     */
    private void redisFetch() {
        Map<String,String>  val = jedis.hgetAll(HUB_PARAMETERS_KEY);
        parametersTO = HubParametersTO.valueOf(val);
        parameters = parametersTO.toHubParameters();
    }

    /*
     * Stores to REDIS hub parameters
     */
    private void redisStore() {
       Map<String, String> val = parametersTO.toMap();
        jedis.hmset(HUB_PARAMETERS_KEY, val);
    }


}
