package com.home.javacommon.study.lambda.example1;

import com.home.javacommon.study.lambda.Cal;
import com.home.javacommon.study.lambda.Example;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExampleIntClass implements Example {

    @Override
    public void runApp() {
        Cal cal = new Cal() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };

        int c = cal.add(3,4);
        log.info("3 + 4 = {}", c);

    }


}
