package com.home.javacommon.study.inhert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySuperTest {

    @Test
    void buildString() throws Exception {
        MySub object = new MySub();
        System.out.println(object.buildString("O, "));

        MySuper object2 = new MySub();
        System.out.println(object2.buildString("O, "));

        MySuper object3 = new MySuper();
        System.out.println(object3.buildString("O,"));

        MySuper object4 = new MySuper();
        System.out.println(object4.buildString("O, "));

        MySuper object5 = new MySuper();
        System.out.println(object5.buildString("O, "));

    }


}