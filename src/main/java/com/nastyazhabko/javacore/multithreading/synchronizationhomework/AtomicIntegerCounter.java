package com.nastyazhabko.javacore.multithreading.synchronizationhomework;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter implements SiteVisitCounter {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void incrementVisitCount() {
        try {
            this.count.incrementAndGet();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getVisitCount() {
        return count.get();
    }
}
