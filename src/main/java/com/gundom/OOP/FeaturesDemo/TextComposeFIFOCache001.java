package com.gundom.OOP.FeaturesDemo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class FIFOCache{
    /**基于此属性记录Key的顺序*/
    private LinkedList<String> keyOrderList=new LinkedList<String>();
    /**基于此map对象试下你数据的缓存*/
    private Map<String,Object> cache=new HashMap<>();

    private int maxCap;
    public FIFOCache(int maxCap){
        this.maxCap=maxCap;
    }

    public void put(String key,Object value){

        keyOrderList.addLast(key);

        if (keyOrderList.size()>maxCap){
            String s = keyOrderList.removeFirst();
            cache.remove(s);
        }
        cache.put(key,value);

    }


    public Object get(String key){
        return cache.get(key);
    }

    @Override
    public String toString() {
        return "FIFOCache{" +
                "keyOrderList=" + keyOrderList +
                ", cache=" + cache +
                ", maxCap=" + maxCap +
                '}';
    }
}

public class TextComposeFIFOCache001 {

    public static void main(String[] args) {
        FIFOCache cache=new FIFOCache(3);
        cache.put("a",100);
        cache.put("b",200);
        cache.put("v",500);
        cache.put("w",600);
        cache.put("L",600);

        System.out.println(cache);

    }

}
