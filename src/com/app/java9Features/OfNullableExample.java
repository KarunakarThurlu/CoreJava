package com.app.java9Features;

import java.util.stream.Stream;

/*
 * Stream.ofNullable() takes an element and produces a Stream of single element if the specified element is non-null, otherwise an empty Stream -
 * 
 * 
 */
public class OfNullableExample {
	public static void main(String[] args) {
		
		Stream.ofNullable("Hello java9").forEach(System.out::println);
	    //output:- Hello java9
		
		Stream.ofNullable(null).forEach(System.out::println);
		//output:- <empty stream>

	}
}
