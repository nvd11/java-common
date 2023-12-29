package com.home.javacommon.dummytest.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

public class Test1 {
    public static void main(String[] args) {
        // Parent<Integer> p = new Parent<>("Hello");   // error
        Parent<String> p = new Parent<>("Hello");
        Child<Integer> c = new Child<>(100);

        p.printAttr();
        c.printAttr();
        c.setAttr(2000);
        c.printAttr();
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
class Parent<T> {
    private T attr;

    public void printAttr() {
        log.info("Parent: attr is {}", this.getAttr());

    }
}


@Slf4j
class Child<G> extends Parent<G> {
    public Child(G g){
        super(g);
    }

    @Override
    public void printAttr(){
        log.info("Child: attr is {}", this.getAttr());
    }

}
