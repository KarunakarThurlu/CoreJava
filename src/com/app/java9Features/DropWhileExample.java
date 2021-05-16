package com.app.java9Features;

import java.util.List;
import java.util.Set;

/* * *Drop elements from a Stream while a predicate holds.* * *
 * 
 * 1).Stream.dropWhile() is the opposite of Stream.takeWhile(). 
 * 2).It drops elements from a Stream while a predicate holds.
 * 3).Once it encounters an element for which the predicate fails, It stops testing and returns that element and all the elements following that.
 * 
 */
public class DropWhileExample {
	public static void main(String[] args) {
		
		//predictable result,B'z List is ordered collection
		var listOfNames=List.of("Karun","meanon","jhon","linda","varun","tarun","doyana");
		    listOfNames.stream()
		    		   .dropWhile(DropWhileExample::getAllNamesUntillNotEndsWith_n)
		    		   .forEach(System.out::println);

		    
		//unpredictable result, B'z Set is unordered collection
		var setOfNames=Set.of("Karun","meanon","jhon","linda","varun","tarun","doyana");
			setOfNames.stream()
					  .dropWhile(DropWhileExample::getAllNamesUntillNotEndsWith_n)
					  .forEach(System.out::println);


	}
	public static Boolean getAllNamesUntillNotEndsWith_n(String name) {
		return name.endsWith("n")?true:false;
	}

}
