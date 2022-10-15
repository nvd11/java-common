package com.home.javacommon.study.generics.simplewildcard;

import lombok.extern.slf4j.Slf4j;

public class SimpleWildCard {
    public static void main(String[] args) {
        new TestBox().test();
    }    
}


class Box<T>{
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

@Slf4j
class TestBox{
    public void test(){
        Box<Number> box1 = new Box<>();
        box1.setItem(3);
        printBox(box1);

        Box<Integer> box2 = new Box<>();
        box2.setItem(4);
        printBox(box2);
        
    }

    public void printBox(Box<? extends Number> box){
        log.info("item is: {}", String.valueOf(box.getItem())) ;
    }
}