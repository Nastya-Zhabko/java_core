package com.nastyazhabko.javacore.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionsInRealIssues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите путь до файла: ");
        int count = 1;
        try {
            Path path = Paths.get(sc.nextLine());

            if (!Files.exists(path)) {
                throw new FileNotFoundException(path.toString());
            }
            String content = Files.readString(path);
            String firstLine = content.split("/n")[0];
            for (int i = 0; i < firstLine.length(); i++) {
                if (firstLine.charAt(i) == ' ') {
                    count++;
                }
            }
            System.out.println("В первой строке файла " + count+ " слов.");


        }
        catch (FileNotFoundException e){
            System.out.println("Файл не найден!");
        }
        catch (IOException e){
            System.out.println("Ошибка ввода-вывода");
        }
        catch (InputMismatchException e){
            System.out.println("Вы ввели что-то странное...");
        }
        finally {
            sc.close();
            System.out.println("Спасибо за использование!");
        }


    }
}
