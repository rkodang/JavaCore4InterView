package com.gundom.Cache;

import org.apache.ibatis.cache.CacheException;

import java.io.*;

public class SerializedCache implements Cache{

    private Cache cache;

    public SerializedCache(Cache cache) {
        this.cache = cache;
    }
    //反序列化
    private Object deSerialize(byte[] array) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(array));
        objectInputStream.close();
        return objectInputStream.readObject();
    }
    //序列化
    private byte[] serialize(Object value) throws Exception {
        //字节数组输出流,内置一个可扩容的数组
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();//(输出流对象)
        //1.构建流对象
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        //2.基于流对象进行序列化
        objectOutputStream.writeObject(value);
        objectOutputStream.flush();
        //3.获取自己数组然后范围;
        byte[] bytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        objectOutputStream.close();
        return bytes;
    }

    @Override
    public void putObejct(Object key, Object value) {
        try {
            //1.将对象序列化,转换为字节
            byte[] array = serialize(value);
            //2.字节数组存储到cache对象
            cache.putObejct(key,array);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getObject(Object key) {
        try {
            byte[] array= (byte[]) cache.getObject(key);
            return  array==null?null:deSerialize(array);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Object removeObject(Object  key) {
        return cache.removeObject(key);
    }
}
