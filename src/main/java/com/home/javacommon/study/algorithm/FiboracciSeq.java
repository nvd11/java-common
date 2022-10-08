package com.home.javacommon.study.algorithm;

import java.util.Arrays;
import java.util.List;

public class FiboracciSeq {
    public static void main(String... args){
        RabbitCount rb = new RabbitCount();
        List<Integer> rabbitCountList = Arrays.asList(rb.f(1), rb.f(2),rb.f(3),rb.f(4),rb.f(5),rb.f(6));
        rabbitCountList.forEach(System.out::println);
    }

}

/**
 * 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * 分析 https://mp.csdn.net/mp_blog/creation/success/127217870
 */
class RabbitCount{

    /**
     *
     * @param n 月份
     * @return 兔子数量
     */
    public int f(int n){
        if (n<3){
            return 1;
        }
        return f(n-1) + g(n-1);
    }

    /**
     *
     * @param n
     * @return n 下个月会新增的兔子数量
     */
    public int g(int n){
        if (n<3){
            return 1;
        }
        return f(n-1);
    }

}

