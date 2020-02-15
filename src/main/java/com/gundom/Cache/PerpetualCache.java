package com.gundom.Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 永久性Cache:不涉及缓存淘汰策略
 *  -不记录元素顺序
 */
public class PerpetualCache  implements Cache{

    private Map<Object,Object> cache=new HashMap<>();

    @Override
    public void putObejct(Object key, Object value) {

        cache.put(key,value);
    }

    @Override
    public Object getObject(Object key) {
        return cache.get(key);
    }

    @Override
    public Object removeObject(Object key) {
        return cache.remove(key);
    }

    @Override
    public String toString() {
        return "PerpetualCache{" +
                "cache=" + cache +
                '}';
    }
}
