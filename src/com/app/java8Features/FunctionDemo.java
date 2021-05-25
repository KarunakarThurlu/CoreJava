package com.app.java8Features;

import java.util.function.Function;

public class FunctionDemo{

	public static void main(String[] args) {
	
		Function<String, Integer> fun=(a)->{		
			return a.length();
		};
		Integer length=fun.apply("foo");
		System.out.println(length);
		
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