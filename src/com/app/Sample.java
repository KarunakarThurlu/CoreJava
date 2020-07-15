package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

interface Sample {
	public static void main(String[] args) {
		List<String> al=new ArrayList<>();
		al.add("karun");
		al.add("Java");
		al.add("Spring");
		al.add("SpringBoot");
		al.add("Java");
		al.add(null);
		al.add(null);
		
		System.out.println(al);
		al.stream().forEach(s->{
			
		       System.out.print(s+" ");
		});
		System.out.println();
		List<String> ll=new LinkedList<>();
		ll.add("React");
		ll.add("Java");
		ll.add("Spring");
		ll.add("SpringBoot");
		ll.add("Java");
		ll.add(null);
		ll.add(null);
		ll.add("JavaScript");
		System.out.println();
		ll.stream().parallel().forEach(s->System.out.println(s+"  "+Thread.currentThread().getName()));
		System.out.println();
		System.out.println(ll);
		int[] a= {23,45,56,67,87,12,32,98};
		int sum=Arrays.stream(a).sum();
		System.out.println(sum);
	}
}
