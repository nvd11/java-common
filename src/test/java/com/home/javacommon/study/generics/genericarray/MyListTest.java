package com.home.javacommon.study.generics.genericarray;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyListTest {

    @Test
    void testMyBase() {
        MyBase<String> mybase = new MyBase<String>(){};
        log.info("E class is {}",mybase.getEClass());
    }

    @Test
    void testGetEClass() {
        MyList<String> mylist = new MyList<String>();
        log.info("E class is {}",mylist.getEClass());
    }

    @Test
    void testGetEClass2() {
        MySet myset = new MySet();
        log.info("Set E class is {}",myset.getEClass());
    }

    @Test
    void testGetEClass3() {
        MyMap<String> myMap= new MyMap<>(String.class);
        log.info("Set E class is {}",myMap.getEClass());
    }
}
