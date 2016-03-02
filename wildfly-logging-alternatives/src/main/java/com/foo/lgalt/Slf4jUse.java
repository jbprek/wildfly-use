package com.foo.lgalt;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author prekezes.
 */


@Singleton
@Startup
public class Slf4jUse {

    public static Logger log  = LoggerFactory.getLogger(Slf4jUse.class);
    public static final DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");

    @PostConstruct
    public void setup() {
        log.info("Started");
    }

    /**
     * Automatic Timeout examples
     * Every minute
     */
    @Schedule(hour = "*", minute = "*/1")
    private void everyMinuteTimeout() {
        log.info("everyMinuteTimeout : Timeout at" + dateFormat
                .format(new Date()));
    }
}
