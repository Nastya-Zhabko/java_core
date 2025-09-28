package com.nastyazhabko.javacore.multithreading.synchronizationhomework;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<SiteVisitCounter> counters = List.of(
                new UnsynchronizedCounter(),
                new VolatileCounter(),
                new SynchronizedBlockCounter(),
                new AtomicIntegerCounter(),
                new ReentrantLockCounter()
        );

        for (SiteVisitCounter counter : counters) {
            MultithreadingSiteVisitor visitor = new MultithreadingSiteVisitor(counter);
            visitor.visitMultithread(100);
            visitor.waitUntilAllVisited();
            System.out.println(counter.getClass().getSimpleName());
            System.out.println(counter.getVisitCount());
            System.out.println(visitor.getTotalTimeOfHandling());
        }
    }
}
