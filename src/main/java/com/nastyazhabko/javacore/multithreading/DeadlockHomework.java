package com.nastyazhabko.javacore.multithreading;

public class DeadlockHomework {

    public static void main(String[] args) {
        Object resource1 = new Object();
        Object resource2 = new Object();

        Thread threadA = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Поток A захватил ресурс 1");
                synchronized (resource2) {
                    System.out.println("Поток A захватил ресурс 2");
                }
            }

        });


        Thread threadB = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Поток B захватил ресурс 1");
                synchronized (resource2) {
                    System.out.println("Поток B захватил ресурс 2");
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
