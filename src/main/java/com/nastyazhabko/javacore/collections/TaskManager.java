package com.nastyazhabko.javacore.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TaskManager {
    public static void main(String[] args) {
        List<String> arrayListTaskManager = new ArrayList<>();

        List<String> linkedListTaskManager = new LinkedList<>();

        arrayListTaskManager.add("Task 1");
        arrayListTaskManager.add("Task 2");
        arrayListTaskManager.add("Task 3");

        System.out.println("Задачи arrayListTaskManager: ");
        tasksOutput(arrayListTaskManager);

        linkedListTaskManager.add("Task A");
        linkedListTaskManager.add("Task B");
        linkedListTaskManager.add("Task C");

        System.out.println("Задачи linkedListTaskManager: ");
        tasksOutput(linkedListTaskManager);


        arrayListTaskManager.add(1 ,"Task 4");
        System.out.println("Задачи arrayListTaskManager после добавления элемента на 1 позицию: ");
        tasksOutput(arrayListTaskManager);

        linkedListTaskManager.add(2 ,"Task D");


        System.out.println("Задачи linkedListTaskManager после добавления элемента на 2 позицию: ");
        tasksOutput(linkedListTaskManager);

        arrayListTaskManager.remove(2);
        System.out.println("Задачи arrayListTaskManager после удаления 2 элемента: ");
        tasksOutput(arrayListTaskManager);

        linkedListTaskManager.remove(3);
        System.out.println("Задачи linkedListTaskManager после удаления 3 элемента: ");
        tasksOutput(linkedListTaskManager);


    }

    public static void tasksOutput(List<String> list){
        for(String task : list){
            System.out.println(task);
        }
    }
}
