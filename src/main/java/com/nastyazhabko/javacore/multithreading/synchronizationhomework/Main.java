package com.nastyazhabko.javacore.multithreading.synchronizationhomework;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        UnsynchronizedCounter unsynchronizedCounter = new UnsynchronizedCounter();
        VolatileCounter volatileCounter = new VolatileCounter();
        SynchronizedBlockCounter synchronizedBlockCounter = new SynchronizedBlockCounter();
        AtomicIntegerCounter atomicIntegerCounter = new AtomicIntegerCounter();
        ReentrantLockCounter reentrantLockCounter = new ReentrantLockCounter();


        MultithreadingSiteVisitor multithreadingSiteVisitorUnsynchronizedCounter =
                new MultithreadingSiteVisitor(unsynchronizedCounter);
        multithreadingSiteVisitorUnsynchronizedCounter.visitMultithread(100);
        multithreadingSiteVisitorUnsynchronizedCounter.waitUntilAllVisited();
        System.out.println("Значение счетчика для UnsynchronizedCounter: " + unsynchronizedCounter.getVisitCount());
        System.out.println("Время выполнения для UnsynchronizedCounter: " + multithreadingSiteVisitorUnsynchronizedCounter.getTotalTimeOfHandling());

        MultithreadingSiteVisitor multithreadingSiteVisitorVolatileCounter =
                new MultithreadingSiteVisitor(volatileCounter);
        multithreadingSiteVisitorVolatileCounter.visitMultithread(100);
        multithreadingSiteVisitorVolatileCounter.waitUntilAllVisited();
        System.out.println("Значение счетчика для VolatileCounter: " + volatileCounter.getVisitCount());
        System.out.println("Время выполнения для VolatileCounter: " + multithreadingSiteVisitorVolatileCounter.getTotalTimeOfHandling());


        MultithreadingSiteVisitor multithreadingSiteVisitorSynchronizedBlockCounter
                = new MultithreadingSiteVisitor(synchronizedBlockCounter);
        multithreadingSiteVisitorSynchronizedBlockCounter.visitMultithread(100);
        multithreadingSiteVisitorSynchronizedBlockCounter.waitUntilAllVisited();
        System.out.println("Значение счетчика для SynchronizedBlockCounter: " + synchronizedBlockCounter.getVisitCount());
        System.out.println("Время выполнения для SynchronizedBlockCounter: " + multithreadingSiteVisitorSynchronizedBlockCounter.getTotalTimeOfHandling());


        MultithreadingSiteVisitor multithreadingSiteVisitorAtomicIntegerCounter
                = new MultithreadingSiteVisitor(atomicIntegerCounter);
        multithreadingSiteVisitorAtomicIntegerCounter.visitMultithread(100);
        multithreadingSiteVisitorAtomicIntegerCounter.waitUntilAllVisited();
        System.out.println("Значение счетчика для AtomicIntegerCounter: " + atomicIntegerCounter.getVisitCount());
        System.out.println("Время выполнения для AtomicIntegerCounter: " + multithreadingSiteVisitorAtomicIntegerCounter.getTotalTimeOfHandling());


        MultithreadingSiteVisitor multithreadingSiteVisitorReentrantLockCounter
                = new MultithreadingSiteVisitor(reentrantLockCounter);
        multithreadingSiteVisitorReentrantLockCounter.visitMultithread(100);
        multithreadingSiteVisitorReentrantLockCounter.waitUntilAllVisited();
        System.out.println("Значение счетчика для ReentrantLockCounter: " + reentrantLockCounter.getVisitCount());
        System.out.println("Время выполнения для ReentrantLockCounter: " + multithreadingSiteVisitorReentrantLockCounter.getTotalTimeOfHandling());

    }
}
