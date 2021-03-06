package com.gundom.Serializable;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

class Replay implements Serializable{

    private static final long serialVersionUID = 688658954675510802L;

    private int id;
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private void writeObject(ObjectOutputStream objcet)throws IOException{
        //1.对数据加密
        //2.获取加密对象
        Base64.Encoder encoder = Base64.getEncoder();
        //3.执行加密操作
        byte[] encodeBytes=encoder.encode(Content.getBytes());
        Content=new String(encodeBytes);
        //4.对数据进行默认序列化
        objcet.defaultWriteObject();
        objcet.close();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        //1.对内容进行反序列化
        objectInputStream.defaultReadObject();
        //2.对内容进行解密操作
        //3.获取解密对象
        Base64.Decoder decoder = Base64.getDecoder();
        //4.执行解密操作
        byte[] decode = decoder.decode(Content.getBytes());

        Content=new String(decode);
        objectInputStream.close();

    }

    @Override
    public String toString() {
        return "Replay{" +
                "id=" + id +
                ", Content='" + Content + '\'' +
                '}';
    }
}
public class SerializableText {

    static void server() throws IOException, ClassNotFoundException {
        //1.构建server对象,监听8888port;
        ServerSocket server=new ServerSocket(8888);
        //2.等待客户端的连接
        Socket socket = server.accept();
        System.out.println("客户端已连接");
        //3.获取对象流输入对象
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream ois=new ObjectInputStream(inputStream);
        //4.读取流中对象
        Object object=ois.readObject();
        System.out.println(object);

        socket.close();
        server.close();
        inputStream.close();
        ois.close();

    }
    static void client() throws IOException {
        //1.构建客户端对象
        Socket socket=new Socket("127.0.0.1",8888);
        //2.获取输出流对象
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());

        //3.写对象到服务端
        Replay replay=new Replay();
        replay.setId(123);
        replay.setContent("hello GunDom@@");
        objectOutputStream.writeObject(replay);
        //4.释放资源
        objectOutputStream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Thread(){
            @Override
            public void run() {
                try {
                    server();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    client();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }



}
