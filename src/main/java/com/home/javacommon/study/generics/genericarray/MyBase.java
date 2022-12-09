package com.home.javacommon.study.generics.genericarray;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;

public class MyBase<E> {
    public MyBase(){
        
    }

    public Class<?> getEClass() {
        
        //get the Class object of this own class 
        Class<? extends MyBase> thisClass = this.getClass();

        //get the Type Object of supper class
        Type superClassType = thisClass.getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType)superClassType;

        //get the Generic Type array
        Type[] genTypeArr = pt.getActualTypeArguments();
        Type genType = genTypeArr[0];
        if (false == genType instanceof Class){
            return null;
        }

        return (Class<Object>) genType;
    }
}

