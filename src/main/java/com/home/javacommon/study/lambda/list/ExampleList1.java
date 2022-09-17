package com.home.javacommon.study.lambda.list;

import com.home.javacommon.study.lambda.Cat;
import com.home.javacommon.study.Example;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Slf4j
public class ExampleList1 implements Example {

    @FunctionalInterface
    private interface CatService{
        Cat getCat(String name, int age);
    }


    @Override
    public void runApp() {

        CatService catService=Cat::new;

        List<Cat> list = new ArrayList<>();
        list.add(catService.getCat("Alice", 5));
        list.add(catService.getCat("Dinesh", 3));
        list.add(catService.getCat("Cindy", 4));
        list.add(catService.getCat("Bill", 2));

        //sort by age
        list.sort((o1,o2) -> o1.getAge() - o2.getAge());
        log.info(list.toString());

        //sort by name with Reverse order
        list.sort((o1,o2) -> o2.getName().compareTo(o1.getName()));
        log.info(list.toString());

        //iterate
        list.forEach((o)->log.info(o.toString()));
    }
}
