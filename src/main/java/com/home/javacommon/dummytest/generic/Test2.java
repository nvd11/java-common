package com.home.javacommon.dummytest.generic;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Test2 {

    public static void main(String[] args) {

        RandomGetter<String> strGetter = new RandomGetter<>();

        Set<String> strProdSet = new HashSet<>(Arrays.asList("iphone", "Thinkpad T14", "Chromebook", "Samson S22"));
        strProdSet.forEach(strGetter::addProduct);

        String prod = strGetter.getRandom();
        if (!Objects.isNull(prod)){
            log.info("you got {}", prod);
        }else{
            log.info("you got nothing");
        }

        Set<Integer> moneySet = new HashSet<>(Arrays.asList(100,200,300,400,500,600,1000));
        Integer money = strGetter.getRandom(moneySet);
        log.info("You got the money: {} and the money class is {}", money, money.getClass().getName() );
    }

}

@NoArgsConstructor
class RandomGetter<T> {
    private final Set<T> productSet = new HashSet<>();
    private final Random random = new Random();

    public void addProduct(T t){
        productSet.add(t);
    }

    /**
     *  * It's not a generic method, the T in return or parameters must be the one when instantiate the class object
     * @return T
     */
    public T getRandom() {
        if (productSet.isEmpty()) {
            return null;
        }

        T prod = new ArrayList<>(productSet).get(random.nextInt((productSet.size())));
        return prod;
    }

    /**
     * It's the generic method, the <T> defined in method has no any relationship of the one defined behind class name!
     * 这里第1个G表示定义1个G的泛型， 标识符用G
     * 第一个G表示返回类型是G
     * 第3个G表示参数是1个G类型的Set容器
     * @param prodSet
     * @param <T>
     * @return
     */

    public <G> G getRandom (@NotNull Set<G> prodSet){
        if (prodSet.isEmpty()){
            return null;
        }

        G prod = new ArrayList<>(prodSet).get(this.random.nextInt(prodSet.size()));
        return prod;
    }
}
