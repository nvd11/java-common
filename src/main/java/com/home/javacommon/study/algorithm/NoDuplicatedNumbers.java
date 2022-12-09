package com.home.javacommon.study.algorithm;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;


/**
 * #### 题目
   有1、2、3、4四个数字，能组成多少个互不相同且一个数字中无重复数字的三位数？并把他们都输出。
 */
public class NoDuplicatedNumbers {
    public static void main(String[] args) {
        Set<Integer> resultSet = new NoDuplicatedNumbersUnit().getResult(4);
        System.out.println(MessageFormat.format("count is {0}", resultSet.size()));
        resultSet.forEach(System.out::println);

    }
}


class NoDuplicatedNumbersUnit{
    /**
     * 
     * @param n if n = 4 , means 1,2,3,4, n must larger than 1 and smaller than 10
     * @return a number set that contains all the triple digit numbers and they are Consisted of digits up to n with no repeating digtis. e.g.  124 231 ...
     */
    public Set<Integer> getResult(int n){
        Set<Integer> resultSet = new HashSet<>();

        int start = (int) (Math.pow(10, n-2));
        int end = (int) (Math.pow(10, n-1)) - 1;

        for (int i=start; i < end + 1; i++){
            if (this.checkNumber(i, n)){
                resultSet.add(i);
            }
        }

        return resultSet;

    }

    /**
     * if one of the digit is larger than n, then return false
     * if i have duplicated digits then return false;
     * 
     * @param i a number
     * @return true of false
     */
    private boolean checkNumber(Integer i, int n){
        /*
         * chars() means to get the IntStream of ASII codes, we cannot use the elements as they are ASII codes,
         * So we need to use mapToObj() and Character.getNumericValue to convert ASII code the Integer value
         * why we use Supplier here, it's because Stream object could not execute the terminal function 2 times, to avoid 
         * "stream has already been operated upon or closed" Exception
         */

        Supplier<Stream<Integer>> streamSupplier = () -> i.toString().chars().mapToObj(Character::getNumericValue);;

        /**
         * if one of the digits large than n, then return false;
         */
        if (streamSupplier.get().anyMatch(x-> x > n)){
            return false;
        }

        /*
         * check if there's a pair of duplicated digit, if yes return false;
         */
        if (streamSupplier.get().distinct().count() < n - 1){
            return false;
        }

        return true;
    }


}

