package com.nastyazhabko.javacore.multithreading.synchronizationhomework;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter implements SiteVisitCounter {
    private static int count = 0;
    private static final ReentrantLock lock = new ReentrantLock();


    @Override
    public void incrementVisitCount() {
        lock.lock();
        try {
            this.count++;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }

    @Override
    public int getVisitCount() {
        return count;
    }
}
