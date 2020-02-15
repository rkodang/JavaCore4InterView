package com.gundom.OOP.FeaturesDemo;

import java.util.LinkedHashMap;
import java.util.Map;

class ComposeLruCache{
    private LinkedHashMap<String,Object> cache;

    public ComposeLruCache(int Capacity) {
        cache=new LinkedHashMap<String,Object>(Capacity,  0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
                return size()>Capacity;
            }
        };
    }

    public void put(String key,Object value){
        cache.put(key, value);
    }

    public  Object getObject(String key){
        return cache.get(key);
    }

    @Override
    public String toString() {
        return "ComposeLruCache{" +
                "cache=" + cache +
                '}';
    }
}


public class TestComposeLurCache001 {
    public static void main(String[] args) {
        ComposeLruCache cache =new ComposeLruCache(3);
        cache.put("A",100);
        cache.put("C",200);
        cache.put("w",300);
        cache.getObject("A");
        cache.put("F",440);
        cache.put("K",600);

        System.out.println(cache);
    }
}
