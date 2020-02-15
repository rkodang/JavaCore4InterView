package com.gundom.Generic;


public interface Container<Type> {
    void add(Type t);
    Type get(int index);
}

class AbsContainer<Type> implements Container<Type>{

    @Override
    public void add(Object t) {

    }

    @Override
    public Type get(int index) {
        return null;
    }

    public static void main(String[] args) {

    }
}