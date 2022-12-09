package com.home.javacommon.study.collectionstream;

import com.home.javacommon.study.Example;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilterClient implements Example {

    public static void main(String[] args){
        new StreamFilter1().example1();
        new StreamDistinct1().example1();
        new StreamLimit1().example1();
        new StreamSkip1().example1();
        new StreamMap1().example1();
        new StreamMap2().example1();
        new StreamFlatMap1().example1();
        new StreamSorted1().example1();
    }


    @Override
    public void runApp() {

    }
}

@Slf4j
class StreamFilter1{

    public void example1(){
        List<String> strList = Arrays.asList("abc","cde","BBB","ccc","ecdd","bbbbb1");
        List<String> filteredStrList = strList.stream().filter(x->x.contains("c")).collect(Collectors.toList());
        filteredStrList.forEach(x->log.info(x));

    }


}

@Slf4j
class StreamDistinct1 {
    public void example1(){
        List<String> strList = Arrays.asList("abc","cde","BBB","ccc","ecdd","bbbbb1","cde","BBB","ccc");
        List<String> distinctedStrList = strList.stream().distinct().collect(Collectors.toList());
        distinctedStrList.forEach(x->log.info(x));
    }
}

@Slf4j
class StreamLimit1 {
    public void example1(){
        List<String> strList = Arrays.asList("abc","cde","BBB","ccc","ecdd","bbbbb1","cde","BBB","ccc");
        List<String> limitedStrList = strList.stream().limit(3).collect(Collectors.toList());
        log.info(String.valueOf(limitedStrList));
    }
}

@Slf4j
class StreamSkip1 {
    public void example1(){
        List<String> strList = Arrays.asList("abc","cde","BBB","ccc","ecdd","bbbbb1","cde","BBB","ccc");
        List<String> skipStrList = strList.stream().skip(3).collect(Collectors.toList());
        log.info(String.valueOf(skipStrList));
    }
}

@Slf4j
class StreamMap1 {
    public void example1(){
        List<String> strList = Arrays.asList("abc","cde","BBB","ccc","ecdd","bbbbb1","cde","BBB","ccc");
        List<String> mapStrList = strList.stream().map(x->x + "!!").collect(Collectors.toList());
        log.info(String.valueOf(mapStrList));
    }
}

@Slf4j
class StreamMap2 {
    /**
     * map(Tools::getCharListStream) return a Stream<Stream<Character>> Object
     */
    public void example1(){
        List<String> strList = Arrays.asList("abc","cde","BBB","ccc","ecdd","bbbbb1","cde","BBB","ccc");
        Stream<Stream<Character>> mapStrStream = strList.stream().map(Tools::getCharListStream);
        List<Stream<Character>> mapStrStreamList = mapStrStream.collect(Collectors.toList());
        List<List<Character>> mapStrListList = strList.stream().map(Tools::getCharListStream).collect(Collectors.toList())
                .stream().map(x->x.collect(Collectors.toList())).collect(Collectors.toList());
        log.info(String.valueOf(mapStrStream));
        log.info(String.valueOf(mapStrStreamList));
        log.info(String.valueOf(mapStrListList));
    }
}

@Slf4j
class StreamFlatMap1 {
    /**
     * flatMap(Tools::getCharListStream) return a Stream<Character> Object （merged multiple Stream<Characters> to a single one
     */
    public void example1(){
        List<String> strList = Arrays.asList("abc","cde","BBB","ccc","ecdd","bbbbb1","cde","BBB","ccc");
        //List<Character> flatMapStrSreamList= strList.stream().flatMap(x->x.concat("sdf")).collect(Collectors.toList());
        Stream<Character> flatMapStrStream= strList.stream().flatMap(Tools::getCharListStream);
        List<Character> flatMapStrList = flatMapStrStream.collect(Collectors.toList());
        log.info(String.valueOf(flatMapStrStream));
        log.info(String.valueOf(flatMapStrList));
    }
}


class Tools{
    public static Stream<Character> getCharListStream(String str){
        List<Character> characterList = new ArrayList<>();
        for (char x : str.toCharArray()){
            characterList.add(x);
        }
        return characterList.stream();
    }
}


@Slf4j
class StreamSorted1 {
    /**
     * flatMap(Tools::getCharListStream) return a Stream<Character> Object （merged multiple Stream<Characters> to a single one
     */
    public void example1(){
        List<MyUser> userList = new ArrayList<>();
        userList.add(new MyUser(4L,"Alice"));
        userList.add(new MyUser(3L,"Jack"));
        userList.add(new MyUser(3L,"Bill"));


        List<MyUser> sortedUserList = userList.stream().sorted(Comparator.comparing(MyUser::getName).reversed()
                                                                .thenComparing(MyUser::getId)).collect(Collectors.toList());
        log.info(String.valueOf(sortedUserList));
    }
}
