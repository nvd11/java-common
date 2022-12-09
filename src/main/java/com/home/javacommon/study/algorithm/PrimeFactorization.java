package com.home.javacommon.study.algorithm;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * 质因数分解
 */

public class PrimeFactorization {
    public static void main(String[] args) {
        PrimeFactorizationUitl  pf = new PrimeFactorizationUitl();
        System.out.println(MessageFormat.format("The prime factorization of {0} is {1} ", 5, pf.getResultList(4)));
        System.out.println(MessageFormat.format("The prime factorization of {0} is {1} ", 10, pf.getResultList(10)));
        System.out.println(MessageFormat.format("The prime factorization of {0} is {1} ", 100, pf.getResultList(100)));
        System.out.println(MessageFormat.format("The prime factorization of {0} is {1} ", 89, pf.getResultList(89)));
        System.out.println(MessageFormat.format("The prime factorization of {0} is {1} ", 90, pf.getResultList(90)));
    }
}


class PrimeFactorizationUitl{
    private List<Integer> primeList = new ArrayList<>();

    public List<Integer> getResultList(int n){
        if (n < 2){
            throw new RuntimeException("n cannot be smaller than 2");
        }

        this.primeList.clear();

        /*
         * Just need to try from 1 to n/2
         */
        int checkMax = n/2;

        for (int i=2; i<=checkMax; ){
           
            if (1==n){
                 /*
                    n has been decomposed by prime factors
                */
                break;
            }


            if (0==n%i){
                n = n/i;
                this.primeList.add(i);
                /**
                 * Keep the value of i unchanged and enter the next loop
                 */
                continue;
            }

            i++;
        }

        /*
         * n is a prime number
         */
        if (0 == this.primeList.size()){
            this.primeList.add(n);
        }

        return this.primeList;


    }
}