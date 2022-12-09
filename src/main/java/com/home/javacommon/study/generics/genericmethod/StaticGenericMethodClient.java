package com.home.javacommon.study.generics.genericmethod;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

public class StaticGenericMethodClient {
    public static void main(String... args){
        StaticGen.getClassName("hello", true, 123);
        StaticGen2.getClassName("hello", true, 123);
    }
}

@Slf4j
class StaticGen{
    public static <T,T2,T3> void getClassName(T t, T2 t2, T3 t3){
        log.info("t1 class is {}", t.getClass());
        log.info("t2 class is {}", t2.getClass());
        log.info("t3 class is {}", t3.getClass());
    }
}

@Slf4j
class StaticGen2{
    public static <T> void getClassName(T...t){
        Arrays.stream(t).forEach(x->log.info(x.getClass().getName()));
    }
}

