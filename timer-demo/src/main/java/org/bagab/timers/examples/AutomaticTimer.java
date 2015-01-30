package org.bagab.timers.examples;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Demonstates a cron like timer
 * @author prekezes.
 */

@Stateless
public class AutomaticTimer {
    public static Logger log = Logger.getLogger(AutomaticTimer.class.getName());
    private static final SimpleDateFormat  fmt = new SimpleDateFormat("HH:mm:ss");

    /**
     * Timeouts every minute at 0th second
     */
    @Schedule(hour="*", minute="*", second = "0", persistent = true)
    private void everyMinuteTimeout() {
        log.info("Timeout at" + fmt.format(new Date()));
    }
}
