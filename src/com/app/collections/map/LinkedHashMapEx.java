package com.app.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapEx {
	/*
	 * ***It Implements Map(I) and Extends HashMap(C)
	 * 1). Underlying DataStructure is Double LinkedList
	 * 2). Insertion Order is allowed.
	 * 3). It requires Extra memory compared with HashMap.
	 * 4). It uses Double Linked List to Maintain Order.
	 * 5). null is allowed for both key & values
	 * 
	 */
	public static void main(String[] args) {
		Map<String, Integer> m=new LinkedHashMap<String, Integer>();
		m.put("Car", 3);
		m.put("alexa", 1);
		m.put("google",2);
		m.put("cat",7);
		m.put(null, null);
		m.put(null, null);
		m.put(null, null);
		
		m.entrySet().stream().forEach(e->System.out.println(e+" "+e.hashCode()+" "+e.toString()));	
	}
}
