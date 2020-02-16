package com.gundom.Serializable;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class HelloKryo {

    public static void main(String[] args) throws Exception{
        Kryo kryo = new Kryo();
        kryo.register(Message.class);

        Message object = new Message();
        object.value = "Hello Kryo!";
        object.i=5;

        Output output = new Output(new FileOutputStream("file.bin"));
        kryo.writeObject(output, object);
        output.close();

        System.out.println(output);

        Input input = new Input(new FileInputStream("file.bin"));
        System.out.println(input);
        Message object2 = kryo.readObject(input, Message.class);
        input.close();
        System.out.println(object2);

        byte[] hellos = KryoUtils.serialzable("hello Utils");
        System.out.println(hellos.toString());
        Object deserializable = KryoUtils.deserializable(hellos);
        System.out.println(deserializable);
    }
    static public class Message{
        String value;
        private int i;

        @Override
        public String toString() {
            return "Message{" +
                    "value='" + value + '\'' +
                    ", i=" + i +
                    '}';
        }
    }
}
