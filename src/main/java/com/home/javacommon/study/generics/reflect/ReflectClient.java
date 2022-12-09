package com.home.javacommon.study.generics.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import lombok.Data;
import lombok.ToString;

public class ReflectClient {

    public static void main(String[] args) throws Exception {
       new TestReflect().test();
    }
    
}

@ToString
class Apple{
    private int id;
    private double weight;

    private Apple(int id, double weight){
        this.id = id;
        this.weight = weight;
    }
}

class TestReflect{
    public Apple createObject(int id, double weight) throws NoSuchMethodException, SecurityException, 
                                        InstantiationException, IllegalAccessException, 
                                        IllegalArgumentException, InvocationTargetException{
        Class clz = Apple.class;
        Constructor cstr = clz.getDeclaredConstructor(int.class,double.class);
         //because the constructor defined is private, we need below line to change it to be accessable, 
         //otherwise we will get the Exception below
         //java.lang.IllegalAccessException: Class TestReflect can not access a member of class Apple with modifiers "private"
        cstr.setAccessible(true);
        Object obj = cstr.newInstance(id, weight);
        Apple a = (Apple)obj;
        return a;
    }

    public Apple createObjectWithGeneric(int id, double weight) throws NoSuchMethodException, SecurityException, 
                                        InstantiationException, IllegalAccessException, 
                                        IllegalArgumentException, InvocationTargetException{
        Class<Apple> clz = Apple.class;
        Constructor<Apple>  cstr = clz.getDeclaredConstructor(int.class,double.class);
         //because the constructor defined is private, we need below line to change it to be accessable, 
         //otherwise we will get the Exception below
         //java.lang.IllegalAccessException: Class TestReflect can not access a member of class Apple with modifiers "private"
        cstr.setAccessible(true);
        Apple a = cstr.newInstance(id, weight);
        return a;
    }

    public void test(){
        Apple a;
        try {
            a = createObjectWithGeneric(1, 0.7);
        } catch  (Exception e) {
           e.printStackTrace();
           System.err.println(e.getStackTrace());
           return;
        }
        System.out.println("object is created: ".concat(a.toString()));
    }
}