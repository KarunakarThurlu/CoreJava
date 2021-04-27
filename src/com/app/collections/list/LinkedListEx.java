package com.app.collections.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {
	/*
	 * * * LinkedList is Similar to ArrayList Except the Following
	 * 
	 * 1). Underlying Data Structure is Double Lined List.
	 * 2). Insertion Order is  Allowed.
	 * 3). Duplicate values Allowed.
	 * 
	 
	 */
	public static void main(String ...k) {
		List<String> foos=new LinkedList<>();
		foos.add("Amazon Alexa");
		foos.add("Google Assistant");
		foos.add("Apple Siri");
		foos.add("Mi");
		foos.add("Amazon");
		foos.add("GooglePixel");
		foos.add("GooglePixel");
		foos.add(null);
		foos.add("Zoom");
		System.out.println(foos);
		
		//By Using ForEach
		for(String s:foos) {
			System.out.println(s);
		}
		
		//By Using Streams
		foos.stream().forEach(s->System.out.println(s));
	}
}
