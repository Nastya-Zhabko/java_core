package com.nastyazhabko.javacore.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureHomework {
    public static void main(String[] args) {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int result = 41;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(result < 41) {
                throw new RuntimeException("Имитация сбоя");
            }
            return result;})
                .thenApply(value -> value * 2)
                .exceptionally(ex -> {
                    System.out.println("Ошибка " + ex.getMessage());
                    return 0;
                });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1000;
        });

        CompletableFuture<Integer> future3 = future.thenCombine(future2, (futureNew1, futureNew2) -> {
            return futureNew1 + futureNew2;
        });

        future3.thenAccept(text -> System.out.println("Результат future3 " + text));

        future3.join();
    }
}
