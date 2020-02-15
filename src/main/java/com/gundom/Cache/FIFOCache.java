package com.gundom.Cache;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 此Cache本身不存数据,只负责提供缓存淘汰算法
 */
public class FIFOCache implements Cache {

    private Cache cache;
    /**
     * 以此对象来存储入队列顺序
     */
    private Deque<Object> keyOrderList;
    /**最大容量*/
    private int maxCap;


    public FIFOCache(int maxCap, Cache cache) {
        this.cache=cache;
        this.maxCap = maxCap;
        keyOrderList=new LinkedList<Object>();
    }

    @Override
    public void putObejct(Object key, Object value) {
        keyOrderList.addLast(key);

        if (keyOrderList.size()>maxCap){
            Object oldKey = keyOrderList.removeFirst();
            cache.removeObject(oldKey);
        }
        cache.putObejct(key,value);
    }

    @Override
    public Object getObject(Object key) {
        return cache.getObject(key);
    }

    @Override
    public Object removeObject(Object key) {
        return cache.getObject(key);
    }

    @Override
    public String toString() {
        return "FIFOCache{" +
                "cache=" + cache +
                ", keyOrderList=" + keyOrderList +
                ", maxCap=" + maxCap +
                '}';
    }

    public static void main(String[] args) {
        FIFOCache cache=new FIFOCache(3,new PerpetualCache());
                cache.putObejct("A",1);
                cache.putObejct("V",2);
                cache.putObejct("D",4);
                cache.getObject("A");
                cache.putObejct("L",5);
        System.out.println(cache);
    }
}
