package com.gundom.Serializable;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class KryoUtils {
    private KryoUtils() {
    }
    //-->保证线程安全
    static ThreadLocal<Kryo> tl=new ThreadLocal<Kryo>(){
        @Override
        protected Kryo initialValue() {
            Kryo kryo=new Kryo();
            kryo.setRegistrationRequired(false);
            return kryo;
        }
    };


    public static byte[]  serialzable(Object object) throws IOException {
        Kryo kryo=tl.get();
        kryo.setRegistrationRequired(false);//不用强制注册
        //用byte字节输出流
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        Output output=new Output(byteArrayOutputStream);
        kryo.writeClassAndObject(output,object);
        byteArrayOutputStream.close();
        output.close();
        return byteArrayOutputStream.toByteArray();

    }

    public static Object deserializable(byte[] array){
        Kryo kryo=tl.get();
        kryo.setRegistrationRequired(false);
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(array);
        Input input=new Input(byteArrayInputStream);
        Object object = kryo.readClassAndObject(input);
        input.close();
        return object;
    }
}
