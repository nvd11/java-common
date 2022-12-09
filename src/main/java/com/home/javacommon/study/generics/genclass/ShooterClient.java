package com.home.javacommon.study.generics.genclass;

import com.home.javacommon.study.Example;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 *
 * @param <T> Generic Identification - Type formal parameter
 *            T the type of the specified object when the object is created.
 */
@Slf4j
class Shooter<T> {
    /**
     *  T, will be specified by outer class/object
     */
    private T target;

    public void setTarget(T target){
        this.target = target;
    }

    public T getTarget(){
        return this.target;
    }

    public void shoot(){
        if (!Objects.isNull(this.getTarget())){
            log.info("shoot target: {}", this.getTarget());
        }
    }
}

@Slf4j
public class ShooterClient implements Example {
    public static void main(String[] args){
        example1();
        example2();
    }

    public static void example1(){
        Shooter<String> strShooter = new Shooter<>();
        strShooter.setTarget("A Rabbit");
        strShooter.shoot();
    }

    public static void example2(){
        Shooter<String> strShooter = new Shooter<>();
        strShooter.setTarget("A Rabbit");
        Shooter<Integer> intShooter = new Shooter<>();
        intShooter.setTarget(2333);

        log.info("strShooter's class is {}", strShooter.getClass());
        log.info("intShooter's class is {}", intShooter.getClass());
        log.info("{}", strShooter.getClass() == intShooter.getClass());
    }

    @Override
    public void runApp() {

    }
}
