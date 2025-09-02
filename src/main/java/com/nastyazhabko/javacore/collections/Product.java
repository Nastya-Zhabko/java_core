package com.nastyazhabko.javacore.collections;

public class Product {
    private int id;
    private String name;
    private double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product)obj;
        if (id == product.id) {return true;}
        else return false;
    }

    @Override
    public int hashCode(){
        return 42;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + price;
    }
}
