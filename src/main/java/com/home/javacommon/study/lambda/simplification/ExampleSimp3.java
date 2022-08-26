package com.home.javacommon.study.lambda.simplification;

import com.home.javacommon.study.lambda.Example;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExampleSimp3 implements Example {

    private interface Car{
        void build();
    }

    private interface Bus{
        String build(String color);
    }

    @Override
    public void runApp() {
        //if the core function only has 1 parameter, the parenthesis could be omitted
        Car car1 = () ->{log.info("Cal1 is built");};
        Car car2 = () -> log.info("Cal2 is built");

        Bus bus1 = a->{return "Bus1 is built, Color is " + a;};
        Bus bus2 = a ->"Bus2 is built, Color is " + a;

        car1.build();
        car2.build();
        log.info(bus1.build("yellow"));
        log.info(bus2.build("blue"));
    }
}
