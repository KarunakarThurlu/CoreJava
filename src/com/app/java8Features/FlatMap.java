package com.app.java8Features;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMap {
	public static void main(String[] args) {
		int n[]= {2,3,4,5,6,7,8,91,2,1};
		Stream<int[]> intstream=Stream.of(n);
		IntStream is=intstream.flatMapToInt(s->Arrays.stream(s));
		is.forEach(System.out::println);
	}

}
