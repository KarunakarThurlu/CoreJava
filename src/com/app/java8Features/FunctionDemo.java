package com.app.java8Features;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class FunctionDemo{

	public static void main(String[] args) {
		IntUnaryOperator add      = x -> x + 22;
		IntUnaryOperator subtract = x -> x - 3;
		IntUnaryOperator divide   = x -> x / 7;

	
		IntUnaryOperator fun = add.andThen(subtract).andThen(divide);
		Integer result = fun.applyAsInt(2);
		System.out.println(result);
	}
}
/*

public class FunctionDemo implements Function<String, Integer>{
	@Override
	public Integer apply(String t) {
		return t.length();
	}

	public static void main(String[] args) {
		String str="Vennello Aadapilla";
		FunctionDemo fdemo=new FunctionDemo();
		Integer length=fdemo.apply(str);
		System.out.println(length);	
	}
}

*/