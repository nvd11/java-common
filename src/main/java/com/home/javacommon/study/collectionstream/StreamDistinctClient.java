package com.home.javacommon.study.collectionstream;

import com.home.javacommon.study.Example;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import java.util.function.Predicate;
import java.util.function.Function;

public class StreamDistinctClient implements Example {

    public static void main(String[] args){
        new StreamDistinct2().example();
    }

    @Override
    public void runApp() {

    }
}

@Slf4j
class StreamDistinct2{
    public void example(){
        List<MyUser> userList = new ArrayList<>();
        userList.add(new MyUser(3L,"Jack"));
        userList.add(new MyUser(3L,"Bill"));
        userList.add(new MyUser(4L,"Alice"));

        List<MyUser> disUserList = userList.stream().distinct().collect(Collectors.toList());
        log.info(String.valueOf(disUserList));
        List<MyUser> disUserList2 = userList.stream().filter(distinctByKey(x->x.getId())).collect(Collectors.toList());
        log.info(String.valueOf(disUserList2));

    }
    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}



@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class MyUser{
    private Long id;
    private String name;
}
