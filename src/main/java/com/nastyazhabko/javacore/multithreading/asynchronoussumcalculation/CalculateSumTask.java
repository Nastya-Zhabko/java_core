package com.nastyazhabko.javacore.multithreading.asynchronoussumcalculation;

import java.util.List;
import java.util.concurrent.Callable;

public class CalculateSumTask implements Callable<Integer> {
    private final List<Integer> list;
    private final String name;

    public CalculateSumTask(List<Integer> list, String name) {
        this.list = list;
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Задача " + name + " обрабатывается потоком " + Thread.currentThread().getName());
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        Thread.sleep(200);

        return sum;
    }
}
