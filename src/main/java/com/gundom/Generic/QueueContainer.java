package com.gundom.Generic;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *
 * @param <T> --For Type ->泛型
 */
public class QueueContainer<T> {
    //创建一个Obejct[] 数组
    private Object[] array;

    //数组下标
    private int size;

    public QueueContainer() {
        this(10);
    }

    public QueueContainer(int size) {
        if (size==0){
            throw new IllegalArgumentException("传进来的参数不能为0");
        }
        array=new Object[size];
    }

    public void add(T t){
        if(size==array.length){
            array=Arrays.copyOf(array,array.length*2);
        }
        array[size]=t;
        size++;
    }

    public <T>T take(){
        if (size==0){
            throw new NoSuchElementException("没有元素");
        }
        Object FirstElement = array[0];
        System.arraycopy(array,1,array,0,size-1);
        size--;
        return (T) FirstElement;
    }

    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        return "QueueContainer{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        QueueContainer<Integer> queueContainer=new QueueContainer<Integer>(3);

        queueContainer.add(1);
        queueContainer.add(2);
        queueContainer.add(3);
        System.out.println(queueContainer);
        queueContainer.take();
        System.out.println(queueContainer);
        queueContainer.take();
        System.out.println(queueContainer);

    }
}
