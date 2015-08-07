package org.bagab.timers.examples;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * @author prekezes.
 */
public class ProgrammaticTimer {


    public static Logger log = Logger.getLogger(ProgrammaticTimer.class.getName());

    @Resource
    private TimerService timerService;

    /*
     * This is supposed to lookup the value from another component
     */
    private int getPeriodInSeconds() {
        return 10;
    }

    @PostConstruct
    private void setup() {
        log.info("PostConstruct invocation");
    }


    public void schedulePeriodic(ScheduleExpression se, Serializable timerInfo) {
        TimerConfig tc = new TimerConfig(timerInfo,/*persistent = */ false);
        Timer timer = timerService.createCalendarTimer(se, tc);
        log.info("Flyer will be sent at: " + timer.getNextTimeout());
    }


    @Timeout
    public void send(Timer timer) {
//        if(timer.getInfo() instanceof Email) {
//            Email email = (Email)timer.getInfo();
// Retrieve bidders/sellers and email…

    }


    /**
     * Clear all timers for the specific bean
     */
    public void cancelTimers() {
        for (Timer timer : timerService.getTimers())
            timer.cancel();

    }

}
