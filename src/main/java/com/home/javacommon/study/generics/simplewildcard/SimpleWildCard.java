package com.home.javacommon.study.generics.simplewildcard;

import lombok.extern.slf4j.Slf4j;

public class SimpleWildCard {
    public static void main(String[] args) {
        TestBox tb = new TestBox();
        tb.test();
        tb.test2();
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
    }

    public void test2(){
        Box<Integer> box2 = new Box<>();
        box2.setItem(5);
        printBox(box2);
    }

    public void printBox2(Box<?> box){
        Object e = box.getItem();
        log.info("item is: {}", String.valueOf(e));
    }

    public <T extends Box<?>> void printBox(T box){
        Object e = box.getItem();
        log.info("item is: {}", String.valueOf(e));
    }


}
