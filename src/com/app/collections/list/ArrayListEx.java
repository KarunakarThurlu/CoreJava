package com.app.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListEx {
	/*
	 * 1). Underlying DataStructure is Dynamic Array.
	 * 2). Default initial Capacity is 16.
	 * 3). Duplicate elements are allowed.
	 * 4). null values are allowed any no.of times.
	 * 5). Insertion Order is allowed.
	 * 6). It is not Thread Safe.
	 * 7). If frequent Operation is fetching then go for ArrayList.
	 * 
	 */
	public static void main(String[] args) {
		List<String> foos=new ArrayList<>();
		Collections.synchronizedList(foos);
		Collections.sort(foos,(s1,s2)->s2.compareTo(s1));
		foos.add("Redis");
		foos.add("Durby");
		foos.add("DB2");
		foos.add("GraphQL");
		foos.add("Cassandra");
		foos.add("Kudu");
		foos.add("RedShift");
		System.out.println(foos);
		
		foos.stream().forEach(k->System.out.println(k+" "+k.hashCode()));
		
	}
}
