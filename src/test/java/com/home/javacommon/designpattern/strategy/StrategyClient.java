package com.home.javacommon.designpattern.strategy;

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

    public OperationContext(Operation operation){
        this.operation = operation;
    }

    public int cal(int i, int j){
        return this.operation.getResult(i,j);
    }

}


@Slf4j
public class StrategyClient {

    public static void main(String[] args){
        int i = 2;
        int j = 3;

        Operation del = new OperationDel();
        log.info("{}", new OperationContext(del).cal(i,j));
    }


}
