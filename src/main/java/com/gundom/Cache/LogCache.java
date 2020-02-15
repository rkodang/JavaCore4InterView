package com.gundom.Cache;

/**
 * 要在Cache的基础上添加日志操作
 *  --记录元素的命中率(命中次数/请求次数)
 */
public class LogCache implements Cache {

    private Cache cache;
    private int request;
    private int hit;

    public LogCache(Cache cache) {
        this.cache = cache;
    }

    @Override
    public void putObejct(Object key, Object value) {
        cache.putObejct(key, value);
    }

    @Override
    public Object getObject(Object key) {
        //请求次数
        request++;
        //从cache取数据
        Object obj = cache.getObject(key);
        //记录命中次数
        if (obj!=null){hit++;}
        //输出命令率
        System.out.println("request hits"+hit*1.0/request);
        return obj;
    }

    @Override
    public Object removeObject(Object key) {
        return cache.removeObject(key);
    }

    @Override
    public String toString() {
        return "LogCache{" +
                "cache=" + cache +
                ", request=" + request +
                ", hit=" + hit +
                '}';
    }

    public static void main(String[] args) {
        LogCache logCache = new LogCache(new FIFOCache(3, new PerpetualCache()));

        logCache.putObejct("A",100);
        logCache.putObejct("B",300);
        logCache.putObejct("C",500);
        logCache.putObejct("L",800);
        System.out.println(logCache);
        Object l = logCache.getObject("A");
        System.out.println(l);
        logCache.getObject("L");
    }
}
