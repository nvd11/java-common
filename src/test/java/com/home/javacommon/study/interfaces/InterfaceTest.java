package com.home.javacommon.study.interfaces;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class InterfaceTest {

    @Test
    public void test1(){
        Runnable r = () -> System.out.print("hi");
        new Thread(r).start();
    }


}
