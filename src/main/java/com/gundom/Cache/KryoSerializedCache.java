package com.gundom.Cache;

import com.gundom.Serializable.KryoUtils;

import java.io.IOException;

public class KryoSerializedCache implements Cache {
    private  Cache cache;

    public KryoSerializedCache(Cache cache) {
        this.cache=cache;
    }

    @Override
    public void putObejct(Object key, Object value) throws IOException {
        byte[] serialzable = KryoUtils.serialzable(value);
        cache.putObejct(key,serialzable);
    }

    @Override
    public Object getObject(Object key) {
        byte[] key2Bytes = (byte[]) cache.getObject(key);
        Object deserializable = KryoUtils.deserializable(key2Bytes);

        return deserializable;
    }

    @Override
    public Object removeObject(Object key) {
        return cache.removeObject(key);
    }
}
