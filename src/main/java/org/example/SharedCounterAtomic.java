package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedCounterAtomic implements Counter{
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void increment() {
        count.incrementAndGet();
    }

    @Override
    public int getCount() {
        return count.get();
    }
}
