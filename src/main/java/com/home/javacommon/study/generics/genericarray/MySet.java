package com.home.javacommon.study.generics.genericarray;
import java.lang.reflect.Type;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MySet extends MyBase<String> {
   

    public MySet(){
        //log.info("the Internal Array is initial. length is {}", objArray.length);
    }

    /*
    public Class<E> getEClass() {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType)type;
        Type t = pt.getActualTypeArguments()[0];
        Class<E> c= (Class<E>) t;
        return c;

        // return ((Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
     */

   


}

