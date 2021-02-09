package com.app.collections.list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {
	/*
	 * * * LinkedList is Similar to ArrayList Except the Following
	 * 
	 * 1). Underlying Data Structure is Double Lined List.
	 * 2). Insertion Order is not Allowed.
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		List<String> foos=new LinkedList<>();
		
		foos.add("Alexa");
		foos.add("Google");
		foos.add("Mi");
		foos.add("Amazon");
		foos.add("GooglePixel");
		foos.add("GooglePixel");
		foos.add(null);
		foos.add("Zoom");
		System.out.println(foos);
	}
}
