package com.nastyazhabko.javacore.collections;

import java.util.HashMap;
import java.util.Map;

public class MapRealization {
    public static void main(String[] args) {
        Map<String, Integer> fruitsCount = new HashMap<>();

        fruitsCount.put("Apple", 10);
        fruitsCount.put("Banana", 20);
        fruitsCount.put("Orange", 30);

        System.out.println("Начальное содержимое: ");
        for(HashMap.Entry<String, Integer> entry: fruitsCount.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        fruitsCount.put("Banana", 100);

        System.out.println("Содержимое после изменения колва бананов: ");
        for(HashMap.Entry<String, Integer> entry: fruitsCount.entrySet()){
            System.out.println(entry.getKey()+ ": " + entry.getValue());
        }

        fruitsCount.remove("Orange");

        System.out.println("Содержимое после удаления апельсинов: ");
        for(HashMap.Entry<String, Integer> entry: fruitsCount.entrySet()){
            System.out.println(entry.getKey() +": "+ entry.getValue());
        }



    }
}
