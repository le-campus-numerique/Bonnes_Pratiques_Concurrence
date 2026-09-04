package org.example;

public class SharedCounter implements Counter{
    private  int count = 0;
    @Override
    public void increment() {
        count++;
    }

    @Override
    public int getCount() {
        return count;
    }
}
