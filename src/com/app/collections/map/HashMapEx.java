package com.app.collections.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx {
	/*
	 * 1). Uderlying DataStructure is HashTable
	 * 2). Default Initial capacity is 16
	 * 3). Only one null key is allowed,multiple null values are allowed.
	 * 4). Insertion Order is not Allowed.
	 * 5). Insertion is based on Hashing of keys.
	 * 6). It is not thread-safe(Mutiple threads can perform operations on same object).
	 * 7). Best Sutable for searching area.
	 */
	public static void main(String[] args) {
		Map<String, Integer> m=new HashMap<String, Integer>();
		System.out.println(m);
		m.put("Car", 3);
		m.put("alexa", 1);
		m.put("google",2);
		m.put("cat",7);
		
		
		System.out.println(m.hashCode());
		////System.out.println();
		//m.entrySet().stream().forEach(e->System.out.println(e+" "+e.hashCode()+" "+e.toString()));	
	}
}
