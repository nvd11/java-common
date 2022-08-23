package com.home.javacommon.study.lambda;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Order(value = 1) //frequence of running while startup app
public class LambdaApp1 implements CommandLineRunner {

    public void runApp(){
        log.info("hello");
    }

    @Override
    public void run(String... args) throws Exception {
        this.runApp();
    }
}

