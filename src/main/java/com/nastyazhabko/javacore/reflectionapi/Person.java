package com.nastyazhabko.javacore.reflectionapi;

public class Person implements Comparable<Person> {
    final String name;
    final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello " + name);
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
