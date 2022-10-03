package com.home.javacommon.designpattern.decorator;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

interface Huntable{
    public void hunt();
}

@Slf4j
@AllArgsConstructor
@Getter
class Hunter implements Huntable{
    private String name;
    @Override
    public void hunt(){
      log.info("Hunter {} is hunting", this.name);
    }
}

@Slf4j
abstract class HuntOperation extends Hunter{

    public HuntOperation(String name) {
        super(name);
    }

    private Huntable hunter;

    public HuntOperation(Hunter hunter){
        this(hunter.getName());
        this.hunter = hunter;
    }

    @Override
    public void hunt(){
        if (null != this.hunter){
            this.hunter.hunt();
        }
    }
}

@Slf4j
class HuntTrainDog extends HuntOperation{

    public HuntTrainDog(Hunter hunter) {
        super(hunter);
    }

    @Override
    public void hunt(){
        this.trainDog();
        super.hunt();
    }

    public void trainDog(){
        log.info("Hunter {} is training dog to hit the target", this.getName());
    }
}

@Slf4j
class HuntTakePic extends HuntOperation{

    public HuntTakePic(Hunter hunter) {
        super(hunter);
    }

    @Override
    public void hunt(){
        super.hunt();
        this.takePic();
    }

    public void takePic(){
        log.info("Hunter {} is taking a picture", this.getName());
    }
}




@Slf4j
public class DecoratorClient {
    public static void main(String[] args){
        Hunter bill = new Hunter("bill");
        HuntOperation billOper = new HuntTrainDog(bill);
        HuntOperation billOper2 = new HuntTakePic(billOper);

        billOper2.hunt();

    }

}
