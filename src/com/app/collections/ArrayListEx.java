package com.app.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayListEx {
	public static void main(String[] args) {
	
		List<String> l=Arrays.asList("saritha","namitha","haritha","mamatha","kavitha","susmitha");
		
		Collections.sort(l);
		
		System.out.println(l);
		
		Collections.reverse(l);
		
		System.out.println(l);
		
		l.stream().filter(s->s.startsWith("k")).forEach(System.out::println);
		
		//customized sorting in single step
		l.stream().sorted((o1,o2)->o2.compareTo(o1)).forEach(s->System.out.print(s+" "));
		
		//finding longest string in given array
		l.stream().reduce((o1,o2)->(o1.length()>o2.length())?o1:o2).ifPresent(s->System.out.println(s));
		
		//finding each string repeated how many times
		Map<String,Long> ll=l.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		ll.entrySet().stream().forEach(s->System.out.print(s.getKey()+"="+s.getValue()+" "));
		
		//finding even numbers without any loop
		IntStream.range(1,100).filter(s->s%2==0).forEach(s->System.out.println(s));
		
	}

}
