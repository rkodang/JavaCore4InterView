package com.gumdom.InnerClass;

public class callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 =
                new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
interface Incrementable{
    void increment();
}

class Callee1 implements Incrementable{
    private int i=0;

    @Override
    public void increment() {
        i++;
        System.out.println("callee1自增:"+i);
    }
}

class MyIncrement{
    public void increment(){
        System.out.println("MyIncrement的inrement");
    }

    static void f(MyIncrement mi){
        mi.increment();
    }
}

class Callee2 extends MyIncrement{
    private int i=0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println("calle2的increment:"+i);
    }
    private class Closure implements Incrementable{

        @Override
        public void increment() {
            Callee2.this.increment();
            System.out.println("Clousre中的increment方法");
        }
    }
    Incrementable getCallbackReference(){
        return new Closure();
    }
}

class Caller{
    private Incrementable callbackReference;
    Caller(Incrementable cbh){
        callbackReference=cbh;
    }
    void go(){callbackReference.increment();}
}