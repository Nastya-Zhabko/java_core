package com.nastyazhabko.javacore.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateChecker {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        // Заполнение списка числами от 0 до 100000 с дублированием одного значения
        for (int i = 0; i <= 100000; i++) {
            numbers.add(i);
        }
        numbers.add(50000); // Вставляем дубликат

        long startTime = System.nanoTime();
        Set<Integer> hasDuplicates1 = new HashSet(numbers);
        long durationList = System.nanoTime() - startTime;


        if(hasDuplicates1.size() != numbers.size()){
            System.out.println("В списке есть дубликаты! Найдено за "+durationList);
        }

        boolean hasDuplicates = false;
        startTime = System.nanoTime();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    hasDuplicates = true;
                    break;
                }
            }
            if (hasDuplicates) break;
        }
        long durationList1 = System.nanoTime() - startTime;
        System.out.println("Дубликаты найдены: " + hasDuplicates + " за "+durationList1);
    }
}

