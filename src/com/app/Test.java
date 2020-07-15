package com.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Test {
	static	int a=465;
	static	int f=4;
	public static void main(String[] args) {
		System.out.println("hello world in main");

		//Normal way
		Thread th=new Thread(new Runnable() {
			public void run() {
				System.out.println("hello world in inner thread");	
			}
		});

		// using lambdas
		new Thread(()->System.out.println("hello world in lambda ")).start();
		th.start();

		List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9,10);

		List<Integer> nums=numbers.stream().filter(e->e%2==0).collect(Collectors.toList());
		System.out.println(nums);
		System.out.println(numbers.stream()
				.filter(e->e%2==0)
				.map(e->e*2)
				.reduce(0,(e,t)->(e+t)));

		List<Integer> list=Arrays.asList(1,2,3,4,6,5,7,9,8,10);

		System.out.println(list.stream()
				.filter(Test::isGT5)
				.filter(Test::isEven)
				.map(Test::doubleIt)
				.findFirst());

		Map<String,String> map=new HashMap<>();
		map.put("K","karun");
		map.put("A","avathika");
		map.put("E", "eureka");
		map.put("D", "doyana");
		map.put("J","jessi");

		map.entrySet().stream().forEach(e->System.out.print(e.getKey()+" "+e.getValue()));
		System.out.println();

		list.forEach(e->System.out.print(e+" "));
		list.stream()
		.filter(e->e%2!=0)
		.sorted()
		.map(e->e*2)
		.forEach(e->System.out.println(e))
		;



	}
	public static boolean isGT5(int number) {
		return number>3;
	}
	public static boolean isEven(int number) {
		return number%2==0;
	}
	public static int doubleIt(int number) {
		return number*2;
	}


}
