package com.home.javacommon.study.generics.genwildcarddownlimit;


import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WildCardDownLimit {
    public static void main(String[] args) {
       
        new Test().test1();
    }
}

@AllArgsConstructor
@Data
class Automobile{
    private int id;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Automobile other = (Automobile) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
 
}


@Getter
class Truck extends Automobile{
    private int weight;
    public Truck(int id, int weight) {
        super(id);
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Truck [id=" + this.getId() + ", weight=" + weight + "]";
    }
}

@Getter
class PickupTruck extends Truck{
    private int speed;
    public PickupTruck(int id, int weight, int speed) {
        super(id, weight);
        this.speed = speed;
    }
}

class Test{

    public void test1(){
        TreeSet<Truck> ts = new TreeSet<>(aComparator);
        TreeSet<Truck> ts2 = new TreeSet<>(truckComparator);
        //TreeSet<Truck> ts3 = new TreeSet<>(pComparator); // allow due to   public TreeSet(Comparator<? super E> comparator)

        ts.addAll(Arrays.asList(new Truck(3, 99),new Truck(2, 200),new Truck(1, 19)));
        ts2.addAll(Arrays.asList(new Truck(3, 99),new Truck(2, 200),new Truck(1, 19)));

        System.out.println(ts);
        System.out.println(ts2);
    }

    Comparator<Automobile> aComparator = (o1, o2) -> o1.getId() - o2.getId();
    Comparator<Truck> truckComparator = (o1, o2) -> o1.getWeight() - o2.getWeight();
    Comparator<PickupTruck> pComparator = (o1, o2) -> o1.getSpeed() - o2.getSpeed();
}