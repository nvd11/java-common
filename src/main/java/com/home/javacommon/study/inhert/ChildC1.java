package com.home.javacommon.study.inhert;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChildC1 extends ParentC1 {

    private int age;

    public ChildC1(){
        log.info("ChildC1()..");
    }

    public ChildC1(int id, String name, int age){
        super(id, name);
        this.age = age;
    }


    public ChildC1(int id, String name) {
        //super(id,name);
        this.age = 1;
        log.info("ChildC1(id, name)..");
    }


}
