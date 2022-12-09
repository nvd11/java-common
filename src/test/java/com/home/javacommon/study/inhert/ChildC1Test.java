package com.home.javacommon.study.inhert;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ChildC1Test {

    @Test
    public void test1(){
        ChildC1 c = new ChildC1(3, "jack");
        log.info(c.toString());
    }

    @Test
    public void test2(){
        ChildC1 c = new ChildC1();
        log.info(c.toString());
    }



}