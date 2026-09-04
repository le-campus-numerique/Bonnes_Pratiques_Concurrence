package org.example;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numberOfWorkers = 2;
        CountDownLatch latch = new CountDownLatch(numberOfWorkers);
        Counter counter = new SharedCounterLock();

        for (int i = 0; i < numberOfWorkers; i++) {
            new Thread(new Worker(latch, i, counter)).start();
        }

        latch.await(); // Wait until all workers have finished

        System.out.println("All workers are done.");
        System.out.println("Expected messages count: " + (Worker.NUMBER_OF_MESSAGES * numberOfWorkers));
        System.out.println("Actual messages count: " + counter.getCount());
    }
}