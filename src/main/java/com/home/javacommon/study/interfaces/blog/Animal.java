package com.home.javacommon.study.interfaces.blog;

public abstract class Animal {
    public abstract String getName();
    public abstract void move(String destination);
    public abstract void drink();
}

abstract class Mammal extends Animal{

}

abstract class Reptile extends Animal{

}

interface Huntable{
    public void hunt(Animal a);
}

class Tiger extends Mammal implements Huntable{
    private static String name = "Tiger";
    public String getName(){
        return this.name;
    }

    public void move(String destination){
        System.out.println("Tiger moved to " + destination + ".");
    }

    public void drink(){
        System.out.println("Tiger lower it's head and drink.");
    }

    @Override
    public void hunt(Animal a) {
        System.out.println("Tiger catched " + a.getName() + " and eated it");
    }
}

class Goat extends Mammal{
    private static String name = "Goat";
    public String getName(){
        return this.name;
    }

    public void move(String destination){
        System.out.println("Goat moved to " + destination + ".");
    }

    public void drink(){
        System.out.println("Goat lower it's head and drink.");
    }
}

class Rabbit extends Mammal{
    private static String name = "Rabbit";
    public String getName(){
        return this.name;
    }

    public void move(String destination){
        System.out.println("Rabbit moved to " + destination + ".");
    }

    public void drink(){
        System.out.println("Rabbit put out it's tongue and drink.");
    }
}

class Snake extends Reptile implements Huntable{
    private static String name = "Snake";
    public String getName(){
        return this.name;
    }

    public void move(String destination){
        System.out.println("Snake crawled to " + destination + ".");
    }

    public void drink(){
        System.out.println("Snake dived into water and drink.");
    }

    public void hunt(Animal a){
        System.out.println("Snake coiled " + a.getName() + " and eated it");
    }
}

class Farmer{
    public void bringWater(String destination){
        System.out.println("Farmer bring water to " + destination + ".");
    }

    public void bringAnimal(Animal a,String destination){
        System.out.println("Farmer bring " + a.getName() + " to " + destination + ".");
    }

    public void feedWater(Animal a){
        this.bringWater("Feeding Room");
        a.move("Feeding Room");
        a.drink();
    }

    public void feedAnimal(Animal ht , Animal a){
        this.bringAnimal(a,"Feeding Room");
        ht.move("Feeding Room");
        Huntable hab = (Huntable)ht;
        hab.hunt(a);
    }

}