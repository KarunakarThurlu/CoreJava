package com.app.collections.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetEx {
	/*
	 * 1). Duplicate elements are not allowed
	 * 2). Insertion Order is  allowed.
	 * 
	 */
	public static void main(String[] args) {
		Set<String> foos=new LinkedHashSet<>();
		foos.add("Amazon Alexa");
		foos.add("Google Assistantent");
		foos.add("Apple siri");
		foos.add("Amazon");
		foos.add("GooglePixel");
		foos.add("GooglePixel");
		foos.add("GooglePixel");
		foos.add(null);
		foos.add(null);
		foos.add(null);
		foos.add("Zoom");
		System.out.println(foos);
	}
}
