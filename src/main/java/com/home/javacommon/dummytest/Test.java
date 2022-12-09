package com.home.javacommon.dummytest;

import lombok.extern.slf4j.Slf4j;

public class Test {
    public static void main(String[] args) {
        BB b = new BB();
    }
}

@Slf4j
class AA{

    public AA(){
        log.info("AA");
    }
}

class BB extends AA{

    public BB() {

    }
    
   


}