package com.nastyazhabko.javacore.multithreading.synchronizationhomework;

import java.util.ArrayList;
import java.util.List;

public class MultithreadingSiteVisitor {
    private final SiteVisitCounter siteVisitCounter;
    private final List<Thread> treads = new ArrayList<Thread>();
    private static long startTime;
    private static long endTime;

    public MultithreadingSiteVisitor(SiteVisitCounter siteVisitCounter) {
        this.siteVisitCounter = siteVisitCounter;
    }

    public void visitMultithread(int numOfThreads) {
        startTime = System.currentTimeMillis();

        for (int i = 0; i < numOfThreads; i++) {
            Thread thread = new Thread(() -> {
                siteVisitCounter.incrementVisitCount();
            });
            treads.add(thread);
            thread.start();
        }
    }

    public void waitUntilAllVisited() throws InterruptedException {
        for (Thread thread : treads) {
            thread.join();
        }
        endTime = System.currentTimeMillis();
    }

    public long getTotalTimeOfHandling() {
        return endTime - startTime;
    }
}
