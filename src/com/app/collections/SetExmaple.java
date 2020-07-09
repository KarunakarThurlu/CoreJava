package com.app.collections;

import java.util.HashSet;
import java.util.Set;

public class SetExmaple {
	
	public static void main(String[] args) {
		Set<String> s=new HashSet<>();
		s.add("a");
		s.add("a");
		s.add("b");
		s.add("a");
		System.out.println(s.size());
		s.stream().forEach(l->System.out.println(l));
	}
	
}
