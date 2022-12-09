package com.home.javacommon.study.generics.genwildcarduplimit;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WildCardUpLimit {
    public static void main(String[] args) {
        Truck t = new Truck(1);
        PickupTruck pt = new PickupTruck(2);
        log.info("{}", t);
        log.info("{}", pt);

        new Test().test1();
    }
}


class Automobile{
    public int getId(){
        return 0;
    };
}

@AllArgsConstructor
@Data
class Truck extends Automobile{
    private int id;
    public String toString(){
        return MessageFormat.format("{0}({1}:{2})", this.getClass().getSimpleName(),"id",id);
    }
}


class PickupTruck extends Truck{
    public PickupTruck(int i) {
        super(i);
    }
}

class Test{

    public void test1(){
        ArrayList<Automobile> automobiles = new ArrayList<>();
        automobiles.addAll(Arrays.asList(new Truck(1), new Truck(2)));

        List<Truck> trucks = new ArrayList<>();
        trucks.addAll(Arrays.asList(new Truck(3), new Truck(4)));

        List<PickupTruck> pickupTrucks = new ArrayList<>();
        pickupTrucks.addAll(Arrays.asList(new PickupTruck(1), new PickupTruck(2)));

        //printTruck(automobiles); // not allow due to ? extends Truck
        printTruck(trucks);
        printTruck(pickupTrucks);
    }

    public void printTruck(List<? extends Truck> list){
        for (Truck t: list){
            System.out.println("list : ".concat(t.getClass().getSimpleName()).concat(" - ").concat(t.toString()));
        }
    }

    public void printTruck2(List<? extends Truck> list){
        //list.add(new Truck(23));  not allow

        for (Truck t: list){
            System.out.println("list : ".concat(t.getClass().getSimpleName()).concat(" - ").concat(t.toString()));
        }
    }
}