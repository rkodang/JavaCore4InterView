package com.gumdom.InnerClass;

public class InnerClassText01 {
    void f(){
        System.out.println("DoThis.F()");
    };

    public class Inner{
        public InnerClassText01 outer(){
            //返回的是一个InnerClassText01对象
            return InnerClassText01.this;
        }
    }

    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args) {
        InnerClassText01 ict=new InnerClassText01();
        InnerClassText01.Inner inner=ict.inner();
        System.out.println("inner中this:"+inner.outer());
        System.out.println("public Class:"+ict);
        inner.outer().f();
    }
}
