package com.app.java8Features;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMap 
{
	public static void main(String[] args) 
	{
		var l=List.of(
				List.of(10,20,30,40,50),
				List.of(60,70,90),
				List.of(80,100,110)
				);
		 List<Integer> summ= l.stream().flatMap(s->s.stream()).collect(Collectors.toList());
	     summ.stream().sorted().forEach(s-> System.out.print(s+" "));
	}
}
