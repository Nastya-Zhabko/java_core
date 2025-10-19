package com.nastyazhabko.javacore.multithreading.asynchronoussumcalculation;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        DataProcessor dataProcessor = new DataProcessor(10);

        for (int i = 0; i < 100; i++) {
            dataProcessor.executeTask(List.of(i, i + 1));
        }

        //Только после завершения всех задач программа не останавливается, не могу понять почему
        if (dataProcessor.countOfActiveTasks().get() == 0) {
            dataProcessor.shutdown();
            for (int i = 0; i < 100; i++) {
                System.out.println(dataProcessor.taskResultByName("task" + i));
            }
        }
    }
}
