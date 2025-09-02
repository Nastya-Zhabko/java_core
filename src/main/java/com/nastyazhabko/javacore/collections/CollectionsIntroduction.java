package com.nastyazhabko.javacore.collections;

public class CollectionsIntroduction {
    public static void main(String[] args) {
        GenericBox<String> stringGenericBox1 = new GenericBox<>("Строка первой коробки");

        GenericBox<String> stringGenericBox2 = new GenericBox<>("Строка второй коробки");

        GenericBox<Integer> integerGenericBox = new GenericBox<>(1);

        System.out.println("Объект первой коробки: " + stringGenericBox1.getObject());
        System.out.println("Объект второй коробки: " + stringGenericBox2.getObject());
        System.out.println("Объект интовой коробки: " + integerGenericBox.getObject());

        stringGenericBox1.setObject("Новое значение первой коробки");
        System.out.println(stringGenericBox1.getObject());

        System.out.println("Равна ли вторая коробка первой коробке? " + stringGenericBox2.equals(stringGenericBox1));

        stringGenericBox1.swap(stringGenericBox2);
        System.out.println("Объект первой коробки после swap: " + stringGenericBox1.getObject());
        System.out.println("Объект второй коробки после swap: " + stringGenericBox2.getObject());
    }
}
