package com.home.javacommon.study.generics.genericarray;
import java.lang.reflect.Type;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MyMap<E> {

    private Class<E> eClass;

    public MyMap(Class<E> eClass){
        this.eClass = eClass;
    }

    public Class<E> getEClass(){
        return this.eClass;
    }

}

