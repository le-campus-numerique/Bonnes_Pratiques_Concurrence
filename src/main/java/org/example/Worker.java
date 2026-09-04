package org.example;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {
    public static int NUMBER_OF_MESSAGES = 100000;
    private final CountDownLatch latch;
    private final int workerIndex;
    private Counter globalCounter;

    public Worker(CountDownLatch latch, int workerIndex, Counter sharedCounter){
        this.latch = latch;
        this.workerIndex = workerIndex;
        this.globalCounter = sharedCounter;
    }

    @Override
    public void run() {
        int messageCount = 0;

        try {
            while(messageCount < NUMBER_OF_MESSAGES){
                //System.out.println("Message " + messageCount + " from worker " + workerIndex);
                messageCount++;
                globalCounter.increment();
            }
            System.out.println("Worker " + workerIndex + " have generated " + messageCount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            latch.countDown();
        }
    }
}
