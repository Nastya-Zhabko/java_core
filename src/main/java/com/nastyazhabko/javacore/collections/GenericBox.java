package com.nastyazhabko.javacore.collections;

public class GenericBox<T> {
    private T object;

    public GenericBox(T object){
        this.object = object;
    }

    public T getObject(){
        return object;
    }

    public void setObject(T object){
        this.object = object;
    }

    public boolean equals(GenericBox<T> object) {
        return this.object.equals(object.getObject());

    }

    public void swap(GenericBox<T> object){
        T temp = object.getObject();
        object.setObject(this.getObject());
        this.setObject(temp);
    }
}
