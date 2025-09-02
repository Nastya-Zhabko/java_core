package com.nastyazhabko.javacore.collections;

import java.util.*;

public class deleteDuplicates {
    public static void main(String[] args) {
        //создание и заполнение list
        List<String> list = new ArrayList<String>();
        list.add("Anna");
        list.add("Bob");
        list.add("Carl");
        list.add("Dan");
        list.add("Anna");

        System.out.println("Коллекция до удаления дубликатов");
        for (String s : list) {
            System.out.println(s);
        }

        //удаление дубликатов спривоением list коллекции set
        Set<String> listWithOutDuplicates = new HashSet<String>(list);

        System.out.println("Set");
        for (String s : listWithOutDuplicates) {
            System.out.println(s);
        }

        //добавление в list коллекции set
        list.clear();
        list.addAll(listWithOutDuplicates);

        System.out.println("Коллекция после удаления дубликатов");
        for (String s : list) {
            System.out.println(s);
        }


    }



}
