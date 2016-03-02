package com.foo.lgalt;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @author prekezes.
 */

@Singleton
@Startup
public class JuliUse {

    private static final Logger log = Logger.getLogger(JuliUse.class.getName());
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
