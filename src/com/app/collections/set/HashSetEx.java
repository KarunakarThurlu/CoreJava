package com.app.collections.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
	/*
	 * 1). Duplicate elements are not allowed
	 * 2). Insertion Order is not allowed.
	 * 
	 */
	public static void main(String[] args) {

		Set<String> foos=new HashSet<>();
		
		foos.add("Amazon Alexa");
		foos.add("Google Assistantent");
		foos.add("Apple siri");
		foos.add("Amazon");
		foos.add("GooglePixel");
		foos.add("GooglePixel");
		foos.add(null);
		foos.add("Zoom");
		System.out.println(foos);
		
		//By Using
		for(String s:foos) {
			System.out.println(s);
		}
		
		//By Streams
		foos.stream().forEach(s->System.out.println(s));
	
	}
}
