package com.app.collections.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapEx {
	/*
	 * 1). TreeMap(C) implements Map(I),SortedMap(I),NavigableMap(I).
	 * 2). Underlying Data Structure is Red-Black Tree.
	 * 3). null is allowed for values,for keys it will throw NullpointerException.
	 * 4). Default Natural Sorting Order based on Keys.
	 * 5). Time complexity is O(log(n)), for getting ,setting,removing.
	 * 
	 * 
	 */

	public static void main(String[] args) {
		Map<String, Integer> m=new TreeMap<String, Integer>();
		m.put("Car", 3);
		m.put("alexa", 1);
		m.put("google",2);
		m.put("cat",7);

		m.entrySet().stream().forEach(e->System.out.println(e+" "+e.hashCode()+" "+e.toString()));	
	}
}
