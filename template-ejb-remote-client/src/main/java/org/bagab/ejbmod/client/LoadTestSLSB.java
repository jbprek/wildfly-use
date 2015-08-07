package org.bagab.ejbmod.client;

import org.jboss.as.quickstarts.ejb.remote.stateless.RemoteCalculator;

import javax.naming.NamingException;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
public class LoadTestSLSB {

    private static int numberOfThreads = 10;
    private static int attemptsPerThread = 100;
    private static int millisecondsBetweenAttempts = 100;


    private static ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws NamingException {
        for(int i = 0; i < numberOfThreads; i++)
            System.out.println("Load test start");
            threadPool.submit(new Worker(attemptsPerThread, millisecondsBetweenAttempts));
            System.out.println("Load test start");
    }



    public static  class Worker  implements Callable<WorkerResults> {

        private final int attemptsPerThread;
        private final int millisecondsBetweenAttempts;
//        private final int

        public Worker(int attemptsPerThread, int millisecondsBetweenAttempts) {
            this.attemptsPerThread = attemptsPerThread;
            this.millisecondsBetweenAttempts = millisecondsBetweenAttempts;
        }


        @Override
        public WorkerResults call() throws Exception {
            int successes = 0;
            long workTimeMsecs = 0;

            RemoteCalculator bean = RemoteEJBClient.lookupRemoteStatelessCalculator();
            for (int i =0 ; i < attemptsPerThread; i++ ) {
                Instant start = Instant.now();
                int res = bean.add(0, 1);
                Instant end = Instant.now();
                Duration timeElapsed = Duration.between(start, end);
                workTimeMsecs += timeElapsed.toMillis();
                successes++;
                Thread.sleep(millisecondsBetweenAttempts);
            }

            return new WorkerResults(successes,workTimeMsecs);
        }
    }


    private static class WorkerResults {

        private final int successes;
        private final long workTimeMsecs;

        public WorkerResults(int successes, long workTimeMsecs) {
            this.successes = successes;
            this.workTimeMsecs = workTimeMsecs;
        }

        public int getSuccesses() {
            return successes;
        }

        public long getWorkTimeMsecs() {
            return workTimeMsecs;
        }
    }

}
