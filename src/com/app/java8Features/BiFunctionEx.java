package com.app.java8Features;

import java.util.function.BiFunction;

public class BiFunctionEx {
	
	public static void main(String[] args) {
		BiFunction<String,String,Boolean> biFunction=(a,b)->{
			return a.equals(b);
		};

		Boolean b=biFunction.apply("foo", "foo");
		System.out.println(b);
		
	}
}
