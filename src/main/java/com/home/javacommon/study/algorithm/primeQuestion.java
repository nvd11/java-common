package com.home.javacommon.study.algorithm;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * 算法题： 求1至n的素数列表
 */
public class primeQuestion {
    public static void main(String... args){
       int n = 2000000;

       List<Integer> primeList = new PrimeUitl().getPrimeList(n);

       System.out.println(MessageFormat.format("The list of prime numbers up to {0} is {1}", n, primeList));
        
    }
}

/**
 * Algorithm problem: To Get the list of prime numbers from 1 to n
 * 
 */
class PrimeUitl{

    public PrimeUitl(){
        this.primeList.add(2);
    }

    private List<Integer> primeList = new ArrayList<>();

    private List<Integer> outputList = new ArrayList<>();

    public List<Integer> getPrimeList(int n){

        if (n < 3){
            throw new RuntimeException("n must large than 2");
        }
        
        this.outputList.clear();
        this.outputList.add(1);
        this.outputList.add(2);

        for (int i=3; i <= n; i++ ){
            if (isPrime(i)) {
                this.outputList.add(i);
            }
        }

        return this.outputList;
    }

    /**
     * Use a common list of prime numbers to try to divide the integer n. 
     * If the integer n is divisible by a prime number in the list, then n is a composite number,
     * otherwise n is a prime number, and we will add n to the common prime number list.
     * 
     * @param n
     * @return ture of false
     */
    private boolean isPrime(int n){
        for (Integer x: this.primeList){
            if (x > (int) Math.sqrt(n)){
                break;
            }
            
            /*
             * If n is divisible by x, then n is not a prime number
             */
            if (0 == n%x){
                return false;
            } 
            
        }
        this.primeList.add(n);

        return true;
    }

}