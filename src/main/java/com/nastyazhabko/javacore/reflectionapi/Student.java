package com.nastyazhabko.javacore.reflectionapi;

public class Student {
    private String name;
    private int age;
    public String university;

    public Student(String name, int age, String university){
        this.name = name;
        this.age = age;
        this.university = university;
    }

    private Student(){
    }

    public void introduce(){
        System.out.println("Hello, my name is " + name + " and my age is " + age);
    }

    private void studySecretly() {
        System.out.println("Study something....");
    }

}
