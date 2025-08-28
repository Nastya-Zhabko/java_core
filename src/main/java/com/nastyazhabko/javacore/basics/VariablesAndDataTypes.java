package com.nastyazhabko.javacore.basics;

public class VariablesAndDataTypes {
    public static void main(String[] args) {
        byte countOfStudents = 25;
        short secondsInOneHour = 3600;
        int hoursUntilMy30sBirthday = 376800;
        long earthDiameterInCentimeters = 12_756_274_000L;
        float chipsPrice = 159.99f;
        double earthEquatorInMeters = 40_075_016.686;
        boolean studyToday = true;
        char firstLetterOfMyName = 'A';

        System.out.println("В моей группе учится " + countOfStudents + " студентов");
        System.out.println("В 1 часу " + secondsInOneHour + " секунд");
        System.out.println("До моего 30 летия осталось "+hoursUntilMy30sBirthday+" часов");
        System.out.println("Диаметр Земли в сантиметрах составляет: "+earthDiameterInCentimeters);
        System.out.println("Цена на мои любимые чипсы: "+chipsPrice+" Руб.");
        System.out.println("Экватор земли: "+earthEquatorInMeters+" метров");
        System.out.println("Я сегодня училась? "+studyToday);
        System.out.println("Первая буква моего имени: "+firstLetterOfMyName);

        int newVariableForLongValue = (int) earthDiameterInCentimeters;
        System.out.println(newVariableForLongValue);

        for (int i = 255; i < 260; i++) {
            System.out.println((char)i);
        }
    }
}
