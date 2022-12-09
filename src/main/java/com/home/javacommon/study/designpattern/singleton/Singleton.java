package com.home.javacommon.study.designpattern.singleton;

public class Singleton {
    private String name;
    private Singleton(){
        this.name = "Jason";
    }
    public String getName(){
        return this.name;
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }

}

class Singleton2 {
    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {
        private static final Singleton2 sInstance = new Singleton2();
    }

}