package com.app.java8Features;

import java.util.function.Predicate;

public class PredicateDemo implements Predicate<String> {

	@Override
	public boolean test(String input) {
		String s1=input;
		String s2="";
		boolean ispalinrome=false;
		char ch[]=s1.toCharArray();
		for(int i=ch.length-1;i>=0;i--) {
			s2=ch[i]+s2;
		}
		ispalinrome=s1.equals(s2)?true:false;
		return ispalinrome;
	}
	public static void main(String[] args) {
		Predicate<String> predicate=new PredicateDemo();
		System.out.println("MALAYALAM IS PALINROME : "+predicate.test("MALAYALAM"));
		
		//=====Using Lambda Expression=====
		
		Predicate<String> predicate2=(str)->{
			return str.contains("KA")?true:false;
		};
		System.out.println(predicate2.test("KArunakar"));
	}
}
