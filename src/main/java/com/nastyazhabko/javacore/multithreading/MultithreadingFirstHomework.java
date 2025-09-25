package com.nastyazhabko.javacore.multithreading;

public class MultithreadingFirstHomework {
    static Integer count = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread tread1 = new Thread(() ->{
            for (int i = 0; i < 100; i++) {
                count++;
            }
        });

        Runnable r1 = () -> {
            for (int i = 0; i < 100; i++) {
                count++;
            }
        };

        Thread tread2 = new Thread(r1);

        Thread tread3 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    count++;
                }
            }
        };

        class MyClass extends Thread {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    count++;
                }
            }
        }

        MyClass tread4 = new MyClass();

        tread1.start();
        tread2.start();
        tread3.start();
        tread4.start();

        tread1.join();
        tread2.join();
        tread3.join();
        tread4.join();

        System.out.println(count);

    }
}
