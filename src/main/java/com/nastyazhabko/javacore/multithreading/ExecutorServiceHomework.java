package com.nastyazhabko.javacore.multithreading;

import java.util.concurrent.*;


public class ExecutorServiceHomework {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Задача 1 выполняется в потоке " + Thread.currentThread().getName());
        });

        Future<String> task2 = executor.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Задача 2 выполняется в потоке " + Thread.currentThread().getName());
            return "Задача 2 завершилась";
        });

        executor.execute(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Задача 3 выполняется в потоке " + Thread.currentThread().getName());
        });

        Future<String> task4 = executor.submit(() -> {
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Задача 4 выполняется в потоке " + Thread.currentThread().getName());
            return "Задача 4 завершилась";
        });

        executor.execute(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Задача 5 выполняется в потоке " + Thread.currentThread().getName());
        });

        try {
            System.out.println(task2.get());
            System.out.println(task4.get(3, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            System.out.println("Задача 4 слишком долго выполняется, закрываем ее");
            task4.cancel(true);
        }

        executor.shutdown();

        if (task2.isDone()) {
            System.out.println("Задача 2 выполнилась успешно");
        }
        else {
            System.out.println("Задача 2 не выполнилась успешно");
        }
        if (task4.isCancelled()) {
            System.out.println("Задача 4 отменена");
        }
        else {
            System.out.println("Задача 4 не отменена");
        }

    }
}
