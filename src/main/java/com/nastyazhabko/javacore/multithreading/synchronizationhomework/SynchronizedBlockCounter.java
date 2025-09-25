package com.nastyazhabko.javacore.multithreading.synchronizationhomework;

public class SynchronizedBlockCounter implements SiteVisitCounter {
    private static Integer count = 0;
    Object monitor = new Object();

    @Override
    public void incrementVisitCount() {
        synchronized (monitor) {
            try {
                this.count++;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public int getVisitCount() {
        return count;
    }
}
