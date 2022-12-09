package com.home.javacommon.study.inhert;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParentC1 {

    private int id;
    private String name;

    public ParentC1(){
        this.id = 1;
        this.name = "name";
        log.info("ParentC1()..");
    }


    public ParentC1(int id, String name) {
        this.id = id;
        this.name = name;
        log.info("ParentC1(id, name)..");
    }

    @Override
    public String toString() {
        return "ParentC1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
