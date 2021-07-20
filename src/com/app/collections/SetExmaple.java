package com.app.collections;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;



public class SetExmaple {

	public static void main(String[] args) {
		Set<String> s=new HashSet<>();
		s.add("a");
		s.add("a");
		s.add("b");
		s.add(null);
		System.out.println(s.size());
		foo(s);
	}
	public static void foo(Set<String> list) {
		if(Optional.ofNullable(list).isPresent() && !list.isEmpty())
			list.stream().forEach(l->{
				if(Optional.ofNullable(l).isPresent())
					System.out.println(l.toUpperCase());
			});
	}

}
