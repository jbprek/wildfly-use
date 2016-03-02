package com.foo.lgalt;

import org.apache.log4j.Logger;

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
public class Log4JUse {

    public static Logger log  = Logger.getLogger(Log4JUse.class);
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
