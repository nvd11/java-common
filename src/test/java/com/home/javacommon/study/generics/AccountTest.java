package com.home.javacommon.study.generics;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class AccountTest {

    @Test
    public void test1(){
        AccountA<String> a = new AccountA();
        a.add("a");
        log.info(a.get());

        AccountC<String> c = new AccountC();
        a.add("c");
        log.info(a.get());
    }


}

class AccountA<T> {
    private T accountType;
    public void add(T newType) {accountType= newType;}
    public T get() {return accountType;}

    public  <T extends AccountA> String getFruitName(T t){
        return t.get().toString();
    }
}
/*
class AccountB<T> {
    private<T extends Object> T accountType;
    public void add (<T extends Object> T newType) {accountType=newType;}
    public<T extends Object> T get() {return accountType;}


}
*/
class AccountC<T>{
    private T accountType;
    public void add(T newType) {accountType =newType;}
    public T get() { return accountType;}
}

/*
public class Account(T){
    private Type accountType;
    public void add(Type newType){accountType=newType;}
    public Type get() { return accountType;}
*/