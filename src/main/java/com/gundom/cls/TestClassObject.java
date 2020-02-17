package com.gundom.cls;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ObjectFactory{
    public static Object newInstances(Class<?> cls) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        return newInstances(cls,null,null);
    }

    private static Object newInstances(Class<?> cls, Class<?>[] paramType , Object[] initTargs) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        //通过字节码对象获取构造方法;
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(paramType);

        if(!declaredConstructor.isAccessible()){
            declaredConstructor.setAccessible(true);
        }
        return declaredConstructor.newInstance(initTargs);
    }
}

public class TestClassObject {
    static class ClassAA{
        private ClassAA(){

        }
    }

    static class ClassBB{
        private ClassBB(int i){

        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class<?> date4Class = Class.forName("java.util.Date");
        Object date2Object = ObjectFactory.newInstances(date4Class);
        System.out.println(date2Object);
    }
}
