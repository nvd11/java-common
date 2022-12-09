package com.home.javacommon.study.generics.genericinterface;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InterfaceClient2 {
    public static void main(String[] args){
        Pair<Integer, String> pair = new Pair<>(100, "Apple");
        log.info("pair key is {}",pair.getKey());
        log.info(pair.toString());
    }
}

interface GenericKey<K>{
    public K getKey();
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Pair<K,V> implements GenericKey<K>{

    private K key;
    private V value;

    @Override
    public K getKey() {
        return this.key;
    }
}
