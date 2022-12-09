package com.home.javacommon.study.designpattern.simplefactoryStrategy;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
abstract class Operation {
    public abstract int getResult(int i, int j);
}

@NoArgsConstructor
class OperationAdd extends Operation {

    @Override
    public int getResult(int i, int j){
        return i + j;
    }
}

@NoArgsConstructor
class OperationDel extends Operation {

    @Override
    public int getResult(int i, int j){
        return i - j;
    }
}

class OperationContext{
    private Operation operation;

    public OperationContext(String symbol){
        this.operation = OperationFactory.getOperation(symbol);
    }

    public int cal(int i, int j){
        return this.operation.getResult(i,j);
    }

}

class OperationFactory{
    public static Operation getOperation(String symbol){
        switch (symbol){
            case "+": return new OperationAdd();
            case "-": return new OperationDel();
        }
        return null;
    }
}



@Slf4j
public class SimpleFactoryStrategyClient {

    public static void main(String[] args){
        int i = 2;
        int j = 3;

        log.info("{}", new OperationContext("+").cal(i,j));
    }


}
