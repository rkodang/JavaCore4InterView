package com.gundom.Generic;


import java.util.ArrayList;

class LockArrayList<E> extends ArrayList<E> {

    public static <E>void sumSize(E e){}
    @Override
    public synchronized boolean add(E e) {
        return super.add(e);
    }

    @Override
    public synchronized E get(int index) {
        return super.get(index);
    }
}

public class TextArrayList {
}
