package com.home.javacommon.study.lambda.funcref;

import com.home.javacommon.study.lambda.Example;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class ExampleFunc1 implements Example {

    @Resource
    private CommonCal commonCal;

    @FunctionalInterface
    private interface Cal{
       int cal(int a, int b);
    }

    private static int addAndSquare(int c , int d){
        return (c+d) * (c+d);
    };


    @Override
    public void runApp() {
        Cal add = (a, b)->a + b;
        log.info("5 + 6 = {}", add.cal(5,6));


        log.info("do sth..");
        Cal mult = commonCal::mult;
        log.info("5 * 6 = {}", mult.cal(5,6));

        Cal addAndSquare = ExampleFunc1::addAndSquare;
        log.info("(5 + 6) * (5 + 6) = {}", addAndSquare.cal(5,6));
    }
}
