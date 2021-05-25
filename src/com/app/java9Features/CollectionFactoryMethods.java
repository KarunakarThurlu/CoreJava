package com.app.java9Features;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 1).Java 9 has introduced new factory methods in the collections API to make it easier for developers to create immutable collections.
 * 2).* * * can’t initialize a List, Set or Map with null values when you’re using the new factory methods. * * *
 * 3).Other wise we will get  java.lang.NullPointerException
 * 4).We can’t initialize a Set with duplicate values using the of() factory method -
 *    ex:-Set<String> set = Set.of("A", "B", "A"); //java.lang.IllegalArgumentException thrown: duplicate element: A
 * 5).Not allowed to add duplicate keys while initializing a Map with the new factory method -
 *    ex:-Map.of("A", 1, "A", 2); //java.lang.IllegalArgumentException thrown: duplicate key: A
 *    
 * 6).We can't add values explicitly(ex: l.add(<V>),Otherwise we will get  java.lang.UnsupportedOperationException
 *
 */
public class CollectionFactoryMethods {
	
	public static void main(String... factoryMethodsDemo) {
		
		List<Integer> foos=Arrays.asList(12,34,45,67,78,89);
		var list = List.of();
		System.out.println(list);

		var set  = Set.of("java","scala","spark","julia","go");
		//set.add("s"); java.lang.UnsupportedOperationException
		System.out.println(set);

		
		//By using Map.of(...) Factory Method we can create Map with size upto 10.
		var map    = Map.of("JDK1.5",2004,"JDK1.6",2006,"JDK1.7",2011,"JDK1.8",2014,"JDK1.9","2017");
		System.out.println(map);

		//By using Map.ofEntries(Map.entry(,),Map.entry(,),.....) Factory Method we can create Map with size grater than 10. 
		var a_map  = Map.ofEntries(Map.entry("foo","f"),Map.entry("joo","j"),Map.entry("zoo","z"));
		System.out.println(a_map);


	}
}
