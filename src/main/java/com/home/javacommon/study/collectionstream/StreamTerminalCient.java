package com.home.javacommon.study.collectionstream;

import com.home.javacommon.study.Example;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTerminalCient implements Example {
    @Override
    public void runApp() {
        new StreamAnyMatch1().example1();
    }

    public static void main(String[] args){
        new StreamAnyMatch1().example1();
        new StreamFindFirst1().example1();
        new StreamForEach1().example1();
        new StreamCollect1().example1();
        new StreamCollect2().example1();
        new StreamReduce1().example1();
        new StreamMax1().example1();
    }
}

@Slf4j
class StreamAnyMatch1{
    public void example1(){
        List<String> strList = Arrays.asList("abc","cde","BBB","ccc","ecdd","bbbbb1","cde","BBB","ccc");
        boolean isThere = strList.stream().map(x->x + "!!").anyMatch(x->x.length() < 5);
        log.info(String.valueOf(isThere));
    }
}

@Slf4j
class StreamFindFirst1{
    public void example1(){
        List<String> strList = Arrays.asList("abc","cde","BBB","ccc","ecdd","bbbbb1","cde","BBB","ccc");
        Optional<String> first = strList.stream().map(x->x + "!!").filter(x->x.length() > 5).findFirst();
        log.info(String.valueOf(first.get()));
    }
}

@Slf4j
class StreamForEach1{
    public void example1(){
        List<String> strList = Arrays.asList("abc","cde","BBB","ccc","ecdd","bbbbb1","cde","BBB","ccc");
        strList.stream().map(x->x + "!!").filter(x->x.length() > 5).forEach(x->log.info(x));
    }
}

@Slf4j
class StreamCollect1{
    public void example1(){
        List<String> strList = Arrays.asList("abc","cde","BBB","ccc","ecdd","bbbbb1","cde","BBB","ccc");
        Set<String> strSet = strList.stream().collect(Collectors.toSet());
        log.info(String.valueOf(strSet));
    }
}

@Slf4j
class StreamCollect2{
    public void example1(){
        List<MyUser> userList = new ArrayList<>();
        userList.add(new MyUser(4L,"Alice"));
        userList.add(new MyUser(3L,"Jack"));
        userList.add(new MyUser(3L,"Bill"));
        userList.add(new MyUser(2L,"Ted"));

        //Map<Long,MyUser> myUserMap = userList.stream().collect(Collectors.toMap(MyUser::getId, v->v, (a,b)->a));
        Map<Long,MyUser> myUserMap = userList.stream().collect(Collectors.toMap(MyUser::getId, Function.identity(), (a, b)->a));
        log.info(String.valueOf(myUserMap));
    }
}


@Slf4j
class StreamReduce1{
    public void example1(){
        List<String> strList = Arrays.asList("abc","cde","BBB","ccc","ecdd","bbbbb1","cde","BBB","ccc");
        String sumStr = strList.stream().reduce("sum:", (acc, item)-> acc.concat(item));

        log.info(String.valueOf(sumStr));
    }
}

@Slf4j
class StreamMax1{
    public void example1(){
        List<MyUser> userList = new ArrayList<>();
        userList.add(new MyUser(4L,"Alice"));
        userList.add(new MyUser(3L,"Jack"));
        userList.add(new MyUser(3L,"Bill"));
        userList.add(new MyUser(2L,"Ted"));


        MyUser maxUser = userList.stream().max(Comparator.comparing(MyUser::getId).thenComparing(MyUser::getName)).get();
        log.info(String.valueOf(maxUser));
    }
}

