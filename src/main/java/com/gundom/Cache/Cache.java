package com.gundom.Cache;

import java.io.IOException;

public interface Cache {
    /**
     * 存数据
     * @param key
     * @param value
     */
    public void putObejct(Object key, Object value) throws IOException;

    /**
     * 取数据
     * @param key
     */
    public Object getObject(Object key);

    public Object removeObject(Object key);
}
