package com.home.javacommon.study.generics.genericinterface;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

public class InterfaceClient {
    public static void main(String[] args){
        Fruit apple = new Fruit("Apple");
        apple.printName();
    }
}

interface Generic<T>{
    T getKey();
}

@Slf4j
@AllArgsConstructor
class Fruit implements Generic<String>{

    private String key;

    @Override
    public String getKey() {
        return this.key;
    }

    public void printName(){
        log.info("Fruit name is: {}", this.getKey());
    }
}


