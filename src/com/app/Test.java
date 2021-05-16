package com.app;

import java.util.List;
import java.util.stream.Collectors;

class Test {
	public static void main(String[] args) {
		var list=List.of(2,3,45,64,23,67,89,98,34,44,39,58);
		var result=list.stream()
				.filter(Test::isGraterThan20)
				.filter(Test::isEvenNumber)
				.map(Test::doubleIt)
				.collect(Collectors.toList());
		result.forEach(System.out::println);
	}
	static boolean isGraterThan20(int number) {
		return number>20;	
	}
	static boolean isEvenNumber(int number) {
		System.out.println("isEvenNumber....."+number);
		return number%2==0?true:false;
	}
	static int doubleIt(int num) {
		System.out.println("doubleIt....."+num);
		return num*num;
	}
}



