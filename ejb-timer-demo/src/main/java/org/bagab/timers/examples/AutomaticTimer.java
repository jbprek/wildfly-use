package org.bagab.timers.examples;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Demonstates a cron like timer
 *
 * @author prekezes.
 */

@Stateless
public class AutomaticTimer {

    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public static Logger log = Logger.getLogger(AutomaticTimer.class.getName());

    @PostConstruct
    private void setup() {
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
