package com.mibeez.hub.app;

import com.mibeez.hub.model.HubInfo;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.util.Map;

/**
 * Created by john on 8/18/15.
 */
@Singleton
public class HubInfoService {

    private static final String HUB_INFO_KEY = "hub_info";
    private HubInfo hubInfo = null;
    private Jedis jedis = new Jedis("localhost");

    @PostConstruct
    private void setup() {
        boolean isStored = jedis.exists(HUB_INFO_KEY);
        if (!isStored) {
            updateInstance(new HubInfo());
        }
    }

    @Lock(LockType.READ)
    public HubInfo getInstance() {
        Map<String, String> store = jedis.hgetAll(HUB_INFO_KEY);
        return HubInfo.valueOf(store);
    }

    @Lock(LockType.WRITE)
    public void updateInstance(HubInfo newValue) {

        Map<String,String> hTo = newValue.toMap();
        jedis.hmset(HUB_INFO_KEY, hTo);
    }
}
