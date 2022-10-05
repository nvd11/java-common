package com.home.javacommon.study.generics;

public class Account<T> {
    private T accountType;
    public void set(T newType) {accountType= newType;}
    public T get() {
        return accountType;
    }
}