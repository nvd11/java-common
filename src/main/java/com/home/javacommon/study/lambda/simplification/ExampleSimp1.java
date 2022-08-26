package com.home.javacommon.study.lambda.simplification;

import com.home.javacommon.study.lambda.Cal;
import com.home.javacommon.study.lambda.Example;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
public class ExampleSimp1 implements Example {

    @Override
    public void runApp() {
        //Type of parameter could be removed

        Cal add = (int a , int b) ->{return a + b;};
        Cal add_sim = (a,b) ->{return a + b;}; //  have to omitted together for all the parameters

        log.info("3 + 4 = {}", add.cal(3,4));
        log.info("3 + 4 = {}", add_sim.cal(3,4));


    }
}
