package com.home.javacommon.study.designpattern.observer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

interface Observer{
    void sNotify();
}

interface Publisher<T extends Observer>{
    void setObserver(T t);
    void update();
}


class Target{
    private String target;
    public String getTarget(){
        return this.target;
    }
    public Target(String target){
        this.target = target;
    }
}

@Slf4j
class Commander implements Observer{
    private Target target;

    public void setTarget(Target target){
        log.info("Commander set target is {}: ", target.getTarget());
        this.target = target;
    }

    public Target getTarget(){
        return this.target;
    }

    private List<Publisher> publishersList = new ArrayList<>();

    public void addPublisher(Publisher publisher){
        publisher.setObserver(this);
        this.publishersList.add(publisher);
    }

    @Override
    public void sNotify() {
        log.info("Commander ordered to fire the target: {}", this.target.getTarget());
        for (Publisher publisher : this.publishersList) {

            publisher.update();
        }
    }
}


@Slf4j
class CannonShooter implements Publisher<Commander>{
    private String name;

    public CannonShooter(String name){
        this.name = name;
    }

    private Commander commander;

    @Override
    public void setObserver(Commander commander) {
        this.commander = commander;
    }

    @Override
    public void update() {
        log.info("Canoon Shooter: {} fired the target {}", this.name, this.commander.getTarget().getTarget());
    }
}


public class ObserverClient {
    public static void main(String[] args){
        Commander mike = new Commander();
        mike.setTarget(new Target("The Tree"));

        CannonShooter jack = new CannonShooter("jack");
        CannonShooter bill = new CannonShooter("bill");

        mike.addPublisher(jack);
        mike.addPublisher(bill);

        mike.sNotify();
    }
}
