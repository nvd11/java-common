package com.home.javacommon.study.staticclass;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticClass {
    public static void main(String[] args){
        log.info("StaticClass...");

        OuterClass.StaticInnerClass sinClass= new OuterClass.StaticInnerClass(); // can new static internal class directly

        sinClass.print();

        OuterClass.InnerClass inClass = new OuterClass().new InnerClass(); // must new OuterClass first

        inClass.print();
    }

}
