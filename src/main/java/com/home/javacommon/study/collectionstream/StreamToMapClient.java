package com.home.javacommon.study.collectionstream;

import com.home.javacommon.study.Example;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamToMapClient implements Example {
    @Override
    public void runApp() {

    }

    public static void main(String[] args){
        new StreamToMap2().example1();
        new StreamToMap2().example2();
    }

}

@Slf4j
class StreamToMap2{
    public void example1(){
        List<MyUser> userList = new ArrayList<>();
        userList.add(new MyUser(4L,"Alice"));
        userList.add(new MyUser(3L,"Jack"));
        userList.add(new MyUser(3L,"Bill"));
        userList.add(new MyUser(2L,"Ted"));

        IntStream intStream = IntStream.range(0, userList.size());
        Stream<Integer> iStream = intStream.boxed();

        Map<Integer, MyUser> userMap = iStream.collect(Collectors.toMap(k->k, k->userList.get(k)));
        log.info(String.valueOf(userMap));
    }

    public void example2(){
        List<MyUser> userList = new ArrayList<>();
        userList.add(new MyUser(4L,"Alice"));
        userList.add(new MyUser(3L,"Jack"));
        userList.add(new MyUser(3L,"Bill"));
        userList.add(new MyUser(2L,"Ted"));

        Map<Integer, MyUser> userMap = IntStream.range(0, userList.size()).boxed().collect(Collectors.toMap(Function.identity(), userList::get));
        log.info(String.valueOf(userMap));
    }

}
