package com.mibeez.hub.app;

import com.mibeez.hub.model.HubInfo;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.logging.Logger;

/**
 * Global state
 */
@Startup
@Singleton
@DependsOn({"HardwareMonitor", "HubDAO"})
public class HubApplicationStartup {
    private static final Logger log = Logger.getLogger(HubApplicationStartup.class.getName());

    @EJB
    private HubDAO dao;


    @PostConstruct
    private void setup() {
        log.info("Application Start");
        try {
            if ( dao.getHubInfo() == null)
                dao.hubInit();
        } catch (IotGatewayException e) {
            log.severe("Application Start - Cannot initialize properly due to"+e.getMessage());
        }
    }

}
