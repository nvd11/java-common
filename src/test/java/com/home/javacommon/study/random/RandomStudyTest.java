package com.home.javacommon.study.random;

import com.home.javacommon.study.Example;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Random;

@Slf4j
class RandomStudyTest {

    @Test
    void runApp() {
        Example ram = ()->{
            Random r = new Random();
            int result = r.nextInt(7);
            log.info("{}", result);

        };
        int x = 0;
        while( x < 20 ) {
            ram.runApp();
            x++;
        }

    }
}