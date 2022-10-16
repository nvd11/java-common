package com.home.javacommon.study.generics.genwildcarduplimit2;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WildCardUpLimit {
    public static void main(String[] args) {

        new Test().test1();
    }
}


class Automobile{
    public int getId(){
        return 0;
    };
}

@Data
@AllArgsConstructor
class Goods{
    private int goodsId;
    public String toString(){
        return MessageFormat.format("{0}({1}:{2})", this.getClass().getSimpleName(),"goodsId",goodsId);
    }
}

class Glass extends Goods{
    public Glass(int goodsId) {
        super(goodsId);
    }
}

@AllArgsConstructor
@Data
class Truck<T> extends Automobile{
    private int id;
    private T goods;
    public String toString(){
        return MessageFormat.format("{0}({1}:{2})", this.getClass().getSimpleName(),"id",id);
    }
}


class Test{

    public void test1(){
      Truck<Glass> t = new Truck<>(1, new Glass(2));
      System.out.println(MessageFormat.format("{0}''s goods is {1}", t, t.getGoods()));
    }

    public void printGoods(Truck<? extends Goods> truck){
        System.out.print(truck);
    }

    public void printTruck(List<? extends Automobile> list){
        for (Automobile a: list){
            System.out.println("list : ".concat(a.getClass().getSimpleName()).concat(" - ").concat(a.toString()));
        }
    }
}