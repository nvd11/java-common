package com.home.javacommon.study.lambda.funcref.construct;

import com.home.javacommon.study.lambda.Cat;
import com.home.javacommon.study.lambda.Example;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class ExampleConstruct1 implements Example {


    @FunctionalInterface
    private interface CatServiceNoArgs{
       Cat getCat();
    }

    private interface CatService{
        Cat getCat(String name, int age);
    }


    @Override
    public void runApp() {
        CatServiceNoArgs catService1 = ()->new Cat();
        CatServiceNoArgs catService2=Cat::new;

        log.info(catService1.getCat().toString());
        log.info(catService2.getCat().toString());

        CatService catService3 = (name, age)->new Cat(name, age);
        CatService catService4=Cat::new;

        log.info(catService3.getCat("Alice", 3).toString());
        log.info(catService4.getCat("Bill", 4).toString());
    }
}
