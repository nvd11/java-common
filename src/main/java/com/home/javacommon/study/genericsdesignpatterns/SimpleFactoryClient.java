package com.home.javacommon.study.genericsdesignpatterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleFactoryClient {
	public static void main(String...string) {
		Float x = 1.3f;
		Float y = 4.3f;
		
		Operation<Float> operadd = new OperFactory().getProd("+");
		Double z = operadd.cal(x, y);
		log.info("{} + {} is {}", x, y, z);
	}

}

/**
 * 
 * @author gateman
 *
 * @param <T>
 */
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

class OperFactory<T extends Number>{
	public Operation<T> getProd(String symbol){
		switch (symbol){
			case "+": {
				return new OperAdd<T>();
			}
			case "-": {
				return new OperDel<T>();
			}
		}
		return null;
	}
}


