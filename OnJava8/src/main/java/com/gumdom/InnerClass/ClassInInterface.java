package com.gumdom.InnerClass;

public interface ClassInInterface {
    void howdy();
    class Test implements ClassInInterface{

        @Override
        public void howdy() {
            System.out.println("接口内的内部类");
        }

        public static void main(String[] args) {
            //接口内的方法是自动默认public和static的
            new Test().howdy();
        }
    }
}
