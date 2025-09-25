package com.nastyazhabko.javacore.reflectionapi;

import java.time.LocalDate;

public class Book {
    String title;
    int pages;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    @Author(name="dfgdfgdg1")
    public void setTitle(String title) {
        this.title = title;
    }

    @Author(name="11111dfgdfgdg")
    public int getPages() {
        return pages;
    }


}
