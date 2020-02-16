package com.gundom.Cache;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache implements Cache {

    private final Cache cache;
    private Map<Object,Object> keymap;
    private Object eldestKey;
    public LruCache(Cache cache) {
        this.cache=cache;
        setSize(3);
    }

    private void setSize(final int size) {
        keymap=new LinkedHashMap<Object, Object>(size,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
                boolean tooBig=size()>size;
                if (tooBig) {
                    eldestKey=eldest.getKey();//获取map中第一个元素()
                }

                return tooBig;
            }
        };
    }

    @Override
    public void putObejct(Object key, Object value) throws IOException {
        cache.putObejct(key, value);
        removeOldObject(key);
    }

    private void removeOldObject(Object key) {
        keymap.put(key,key);
        if (eldestKey != null) {
            cache.removeObject(eldestKey);
            eldestKey=null;
        }
    }

    @Override
    public Object getObject(Object key) {
        keymap.get(key);//用于改变keymap内部排序的顺序;将get到的key往最后塞;
        return cache.getObject(key);
    }

    @Override
    public Object removeObject(Object key) {
            keymap.remove(key);
        return cache.removeObject(key);
    }


    @Override
    public String toString() {
        return "LruCache{" +
                "cache=" + cache +
                '}';
    }

    public static void main(String[] args) throws IOException {
        LruCache cache=new LruCache(new PerpetualCache());
        cache.putObejct("A",100);
        cache.putObejct("B",300);
        cache.putObejct("C",500);
        cache.getObject("A");
        cache.putObejct("P",800);
        System.out.println(cache);
    }

}
