package com.home.javacommon.study.generics.genclass.extend;

import com.home.javacommon.study.Example;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

public class extendClient1 implements Example {
    @Override
    public void runApp() {

    }

    public static void main(String[] args){

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
class Parent<T>{
    private T attr;

    public void printAttr(){
        log.info("Parent: attr is {}", this.getAttr());
    }
}

/*
  Do not use @Data @AllArgsConstructor, will have conflicts
 */
@Slf4j
class Child<G> extends Parent<G> {
    public Child(G g){
        super(g);
    }

    public void printAttr(){
        log.info("Child: attr is {}", this.getAttr());
    }
}

@Slf4j
class Son extends Parent<Integer>{
    public Son(Integer i){
        super(i);
    }
    public void printAttr(){
        log.info("Son: attr is {}", this.getAttr());
    }
}

class Client2{
    public static void main(String args[]){
       Son son = new Son(200);
       son.printAttr();
    }
}



class Client{
    public static void main(String args[]){
        Parent<String> parent = new Parent<>("hello");
        Child<Integer> child = new Child<Integer>(200);
        parent.printAttr();
        child.printAttr();
        child.setAttr(100);
        child.printAttr();
    }
}





