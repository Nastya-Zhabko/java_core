package com.nastyazhabko.javacore.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterators {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            numbers.add(i);
        }


        Iterator<Integer> iterator = numbers.iterator();
        while(iterator.hasNext()){
            if(iterator.next() % 2 != 0){
                iterator.remove();
            }
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }



    }
}
