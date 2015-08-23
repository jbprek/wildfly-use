package com.mibeez.hub.app;

import com.mibeez.hub.model.Hub;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.logging.Logger;

/**
 * Global state
 */
@Startup
@Singleton
@DependsOn({"HardwareMonitor", "HubDAO"})
public class IotGatewayServiceStartup {
    private static final Logger log = Logger.getLogger(IotGatewayServiceStartup.class.getName());

    // Hub Information is global and a single instance exists
    private Hub hub;

    private Jedis jedis = new Jedis("localhost");


    @PostConstruct
    private void setup() {
        log.info("Application Start");

    }

}
