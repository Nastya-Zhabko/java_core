package com.nastyazhabko.javacore.multithreading.synchronizationhomework;

public class VolatileCounter implements SiteVisitCounter {
    private volatile int count = 0;

    @Override
    public void incrementVisitCount() {
        try {
            this.count++;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getVisitCount() {
        return count;
    }
}
