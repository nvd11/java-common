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
        CatServiceNoArgs CatService1 = ()->new Cat();
        CatServiceNoArgs CatService2=Cat::new;

        log.info(CatService1.getCat().toString());
        log.info(CatService2.getCat().toString());

        CatService CatService3 = (name, age)->new Cat(name, age);
        CatService CatService4=Cat::new;

        log.info(CatService3.getCat("Alice", 3).toString());
        log.info(CatService4.getCat("Bill", 4).toString());
    }
}
