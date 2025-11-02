package com.nastyazhabko.javacore.multithreading.asynchronoussumcalculation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DataProcessor {
    private AtomicInteger taskCounter = new AtomicInteger();
    private Map<String, Integer> taskResults = new HashMap<String, Integer>();
    private ExecutorService executor;
    private AtomicInteger activeTaskCounter = new AtomicInteger();

    public DataProcessor(Integer executorCount) {
        executor = Executors.newFixedThreadPool(executorCount);
    }

    public void executeTask(List<Integer> nums) {
        activeTaskCounter.incrementAndGet();
        taskCounter.incrementAndGet();
        String taskName = "task" + taskCounter.get();
        CalculateSumTask task = new CalculateSumTask(nums, taskName);
        Future future = executor.submit(task);
        Integer result = null;
        try {
            result = (Integer) future.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (taskResults) {
            taskResults.put(taskName, result);
            System.out.println("Вывод:" + taskResults.get(taskName));
        }

        activeTaskCounter.decrementAndGet();

}

public AtomicInteger countOfActiveTasks() {
    return activeTaskCounter;
}

public Optional<Integer> taskResultByName(String taskName) {
    synchronized (taskResults) {
        return Optional.ofNullable(taskResults.get(taskName));
    }
}

public void shutdown() {
    executor.shutdown();
    try {
        boolean isTerminated = executor.awaitTermination(10, TimeUnit.SECONDS);
        if (!isTerminated) {
            executor.shutdownNow();
        }
    } catch (InterruptedException e) {
        executor.shutdownNow();
        throw new RuntimeException(e);
    }
}
}
