package org.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedCounterLock implements Counter{
    private int count = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        lock.lock();
        try {
            // add some code to protect
            count++;
        } finally{
            lock.unlock();
        }
    }

    @Override
    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally{
            lock.unlock();
        }
    }
}
