package com.app.java9Features;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/*
 * * * Take elements from a Stream while a predicate holds. * * *
 * 1).Stream.takeWhile() method takes elements from a Stream while a predicate holds. 
 * 2).Once the predicate fails, it stops and returns the Stream.
 * 3).In case of Streams obtained from ordered collections, takeWhile() method returns the longest prefix of elements that pass the predicate.
 * 4).When you apply takeWhile() method to a Stream obtained from an unordered collection, the result is unpredictable, because you don’t know in what order the elements will be tested.
 * 
 */
public class TakeWileExample {
	
	public static void main(String... k) {
		
		var list=List.of(2,3,5,7,9,11,13,15,17,19,21,23,29,31,37);
		
		//predictable result,B'z List is ordered collection
		list.stream()
		    .takeWhile(TakeWileExample::findAllPrimesUpToNonPrime)
		    .collect(Collectors.toList())
		    .forEach(System.out::println);
		
		
		var set=Set.of(2,3,5,7,9,11,13,15,17,19,21,23,29,31,37);
		
		//unpredictable result, B'z Set is unordered collection
		set.stream()
		   .takeWhile(TakeWileExample::findAllPrimesUpToNonPrime)
		   .collect(Collectors.toList())
		   .forEach(System.out::println);
				
	}
	public static Boolean findAllPrimesUpToNonPrime(Integer number) {
		return IntStream.range(2, number).noneMatch(x->number%x==0);
	}
}
