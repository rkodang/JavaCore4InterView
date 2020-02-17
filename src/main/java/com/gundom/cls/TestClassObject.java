package com.gundom.cls;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ObjectFactory{
    public static Object newInstances(Class<?> cls) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        return newInstances(cls,null,null);
    }

    static Object newInstances(Class<?> cls, Class<?>[] paramType, Object[] initTargs) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
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
            System.out.println("init ClassAA()");
        }
    }

    static class ClassBB{
        private ClassBB(int i){
            System.out.println("init ClassBB()"+","+i);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class<?> date4Class = Class.forName("java.util.Date");
        Object date2Object = ObjectFactory.newInstances(date4Class);
        System.out.println(date2Object);

        Class<?> classAA = ClassAA.class;
        Object classAA2Object = ObjectFactory.newInstances(classAA);
        System.out.println(classAA2Object);


        Class<?> classBBClass = ClassBB.class;
        Object classBB2Object = ObjectFactory.newInstances(classBBClass,new Class[]{int.class},new Object[]{50});
        System.out.println(classBB2Object);
    }
}
