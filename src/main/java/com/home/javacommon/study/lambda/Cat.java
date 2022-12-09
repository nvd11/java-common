package com.home.javacommon.study.lambda;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cat {

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

}
