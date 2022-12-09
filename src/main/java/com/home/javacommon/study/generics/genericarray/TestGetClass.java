package com.home.javacommon.study.generics.genericarray;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestGetClass{
    public static void main(String[] args)
    {
       new TestClient().test();
       //new TestClient().test();
    }
}

abstract class Foo<T>{
    public Class<T> getTClass()
    {
        Class<T> tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }
}


class TestClient{
    public void test(){
        Foo<String> foo = new Foo<String>(){}; // 注意大括号， 这里实例化的是一个匿名子类， 如果用本类则getClass().getGenericSuperclass() 或返回foo的父类Object类
                                               //强转ParameterizedType 会失败， 所以必须用子类



        // 在类的外部这样获取
        Type type = ((ParameterizedType)foo.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println(type);
        // 在类的内部这样获取
        System.out.println(foo.getTClass());
    }

    public void test2(){
      
    }
}