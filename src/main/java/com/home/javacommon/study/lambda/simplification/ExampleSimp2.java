package com.home.javacommon.study.lambda.simplification;

import com.home.javacommon.study.lambda.Cal;
import com.home.javacommon.study.lambda.Example;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExampleSimp2 implements Example {

    private interface CalOnePara{
        int cal(int a);
    }

    @Override
    public void runApp() {
        //if the core function only has 1 parameter, the parenthesis could be omitted
        CalOnePara add = (a) ->{return a+ 3;};
        CalOnePara add_sim = a->{return a + 3;};

        log.info("4 + 3 = {}", add.cal(4));
        log.info("4 + 3 = {}", add_sim.cal(4));

    }
}
