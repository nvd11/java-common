package com.home.javacommon.designpattern.simplefactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.OpenOption;


@NoArgsConstructor
abstract class Operation {
    public abstract int getResult(int i, int j);
}

@NoArgsConstructor
class OperationAdd extends Operation{

    @Override
    public int getResult(int i, int j){
        return i + j;
    }
}

class OperationDel extends Operation{

    @Override
    public int getResult(int i, int j){
        return i - j;
    }
}

class OperationFactory{
    public static Operation getOperation(String symbol){
        switch(symbol){
            case "+": {
                return new OperationAdd();
            }
            case "-": {
                return new OperationDel();
            }
        }
        return null;
    }
}

@Slf4j
public class OperationCase {
    public static void main(String[] args){
        int i = 2;
        int j = 3;

        Operation add = OperationFactory.getOperation("+");
        log.info("{}", add.getResult(i,j));

        Operation del = OperationFactory.getOperation("-");
        log.info("{}", del.getResult(i,j));

    }
}
