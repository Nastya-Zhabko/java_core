package com.nastyazhabko.javacore.reflectionapi;

import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        Class<?> personClass = Person.class;
        System.out.println("Полное имя класса: "+ personClass.getName());
        System.out.println("Короткое имя класса: "+ personClass.getSimpleName());

        System.out.println("Класс реализует следующие интерфейсы:");
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> i : interfaces) {
            System.out.println(i.getName());
        }

        int modifiers = personClass.getModifiers();
        System.out.println("Модификаторы класса: "+ Modifier.toString(modifiers));

    }
}
