package com.home.javacommon.study.generics.genericmethod;

import com.sun.istack.internal.NotNull;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class GenericMethodClient {
    public static void main(String[] args){
        RandomGetter<String> strGetter = new RandomGetter();
        Set<String> strProdSet = Stream.of("iphone", "Thinkpad T14", "Chromebook", "Samson S22").collect(Collectors.toSet());
        strProdSet.forEach(x->strGetter.addProduct(x));
        String prod = strGetter.getRandom();
        if (!Objects.isNull(prod)){
            log.info("You got the production: {} and the product class is {}", prod, prod.getClass().getName() );
        }else {
            log.info("You got nothing!");
        }

        Set<Integer> moneySet = Stream.of(100,200,300,500,1000,1500,2000).collect(Collectors.toSet());
        Integer money = strGetter.getRandom(moneySet);
        log.info("You got the money: {} and the money class is {}", money, money.getClass().getName() );

    }
}

class RandomGetter<T>{
    private Set<T> productSet = new HashSet<>();
    private Random random = new Random();
    public void addProduct(T t){
        productSet.add(t);
    }

    /**
     * It's not a generic method, the T in return or parameters must be the one when instantiate the class object
     * @return T
     */
    public T getRandom() {
        if (productSet.size() == 0){
           return null;
        }

        T prod = productSet.stream().collect(Collectors.toList()).get(random.nextInt(productSet.size()));
        return prod;
    }

    /**
     * It's the generic method, the <T> defined in method has no any relationship of the one defined behind class name!
     * @param prodSet
     * @param <T>
     * @return
     */
    public <T> T getRandom(@NotNull Set<T> prodSet){
        if (Objects.isNull(prodSet) || 0 == prodSet.size()){
            return null;
        }
        T prod = prodSet.stream().collect(Collectors.toList()).get(random.nextInt(prodSet.size()));
        return prod;
    }

}
