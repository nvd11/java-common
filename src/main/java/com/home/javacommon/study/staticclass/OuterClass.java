package com.home.javacommon.study.staticclass;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OuterClass {
    private static int outerStaticVar = 10;
    private int outerNonStaticVar = 20;

    static class StaticInnerClass {
        public void print() {
            log.info("Outer static variable: " + outerStaticVar);  // able to access static members of outer class
            // log.info("Outer non-static variable: " + outerNonStaticVar);  // Error, cannot access non-static members of outer class
        }
    }

    class InnerClass {
        public void print() {
            log.info("Outer static variable: " + outerStaticVar);  // able to access static members of outer class
            log.info("Outer non-static variable: " + outerNonStaticVar);  // able to access non-static members of outer class as well
        }
    }
}
