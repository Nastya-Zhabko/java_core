package com.nastyazhabko.javacore.reflectionapi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main2 {
    public static void main(String[] args) {
        try {
            Constructor constructor = Student.class.getDeclaredConstructor();
            constructor.setAccessible(true);

            Student student = (Student) constructor.newInstance();

            student.introduce();

            Field[] fields = Student.class.getDeclaredFields();
            fields[0].setAccessible(true);

            for (Field field : fields) {
                System.out.println(field.getName());
            }

            Field nameField = fields[0];
            String oldName = (String) nameField.get(student);
            System.out.println("До изменения значения поля " + oldName);

            nameField.set(student, "Gena");

            String newName = (String) nameField.get(student);

            System.out.println("После изменения значения поля " + newName);


            Method method = Student.class.getDeclaredMethod("studySecretly");
            method.setAccessible(true);
            method.invoke(student);


        }
        catch (NoSuchMethodException e) {} catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
