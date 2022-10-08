package com.home.javacommon.study.genericsdesignpatterns.observer;


import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

public class ObserverClient {
    public static void main(String... args){
        Commander jack = new Commander("Jack");
        Publisher bill = new CannonShooter("Bill");
        Publisher mike = new CannonShooter("Mike");

        jack.setTarget(new Target("The Tree"));
        jack.addFollower(bill);
        jack.addFollower(mike);
        jack.sNotify();
    }
}

interface Observer{
    void sNotify();
}

interface Publisher<T extends Observer>{
    void setObserver(T observer);
    void update();
}

class Target<T>{
    private T target;
    public T getTarget(){
        return this.target;
    }
    public Target(T target){
        this.target = target;
    }
}

@Slf4j
class Commander implements Observer{

    public Commander(String name){
        this.name = name;
    }

    private Set<Publisher> followers = new HashSet<>();

    public void addFollower(Publisher follower){
        follower.setObserver(this);
        this.followers.add(follower);
    }

    private String name;
    private Target target;

    public void setTarget(Target target) {
        log.info("Commander {} have set the target to {}", this.name, target.getTarget());
        this.target = target;
    }

    public Target getTarget(){
        return this.target;
    }

    @Override
    public void sNotify() {
        log.info("Commander {} have ordered to shoot the target", this.name, target.getTarget());
        this.followers.forEach(x ->x.update());
    }
}

@Slf4j
class CannonShooter implements Publisher<Commander>{

    private Commander commander;
    private String name;

    public CannonShooter(String name){
        this.name = name;
    }

    @Override
    public void setObserver(Commander observer) {
        this.commander = observer;
    }

    @Override
    public void update() {
        log.info("CannonShooter {} shoots the target {}", this.name, this.commander.getTarget().getTarget());
    }
}
