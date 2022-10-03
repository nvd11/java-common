package com.home.javacommon.designpattern.builder;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
class CarProduct{
    private List<String> partList = new ArrayList<>();

    private String brand;

    void addPart(String part){
        this.partList.add(part);
    }

    void setBrand(String brandName){
        this.brand = brandName;
    }

    public void show(){
        log.info("{} : {}", this.brand, this.partList);
    }
}


abstract class CarBuilder{
    private CarProduct prod = new CarProduct();
    public CarProduct getProd(){
        return prod;
    }

    abstract void setBrand();
    abstract void buildEngine();
    abstract void buildBody();
    abstract void buildWheels();
}

class FortCarBuilder extends CarBuilder {

    @Override
    void setBrand() {
        // TODO Auto-generated method stub
        this.getProd().setBrand("Fort");
    }

    @Override
    void buildEngine() {
        // TODO Auto-generated method stub
        this.getProd().addPart("Fort-Engine");
    }

    @Override
    void buildBody() {
        // TODO Auto-generated method stub
        this.getProd().addPart("Fort-Body");
    }

    @Override
    void buildWheels() {
        // TODO Auto-generated method stub
        this.getProd().addPart("Fort-Wheels");
    }

}


class BenzCarBuilder extends CarBuilder {

    @Override
    void setBrand() {
        // TODO Auto-generated method stub
        this.getProd().setBrand("Benz");
    }

    @Override
    void buildEngine() {
        // TODO Auto-generated method stub
        this.getProd().addPart("Benz-Engine");
    }

    @Override
    void buildBody() {
        // TODO Auto-generated method stub
        this.getProd().addPart("Benz-Body");
    }

    @Override
    void buildWheels() {
        // TODO Auto-generated method stub
        this.getProd().addPart("Benz-Wheels");
    }

}


class CarDirector {
    public void construct(CarBuilder cb) {
        cb.setBrand();
        cb.buildEngine();
        cb.buildBody();
        cb.buildWheels();
    }

}

public class BuilderClient{
    public static void main(String[] args){
        CarBuilder bill = new FortCarBuilder();
        CarBuilder jack = new BenzCarBuilder();

        CarDirector mike = new CarDirector();

        mike.construct(bill);
        bill.getProd().show();

        mike.construct(jack);
        jack.getProd().show();
    }
}



