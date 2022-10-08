package com.home.javacommon.study.genericsdesignpatterns.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyClient {

	public static void main(String...strings) {
		int x = 3;
		int y = 8;
		
		double z = new OperationContext<Integer>("+").getResult(x, y);
		log.info("{} + {} is {}", x, y, z);
	}
}


abstract class Operation<T extends Number>{
	public abstract Double cal(T x, T y);
}

class OperAdd<T extends Number> extends Operation<T>{

	@Override
	public Double cal(T x, T y) {
		return x.doubleValue() + y.doubleValue();
	}
	
}

class OperDel<T extends Number> extends Operation<T>{

	@Override
	public Double cal(T x, T y) {
		return x.doubleValue() - y.doubleValue();
	}
	
}

class OperationContext<T extends Number>{
	private Operation<T> operation;
	
	public OperationContext(String symbol) {
		switch(symbol) {
			case "+": {
				this.operation = new OperAdd<T>();
				break;
			}
			case "-": {
				this.operation = new OperDel<T>();
				break;
			}
		}
	}
	
	public Double getResult(T x, T y) {
		return this.operation.cal(x, y);
	}
}

