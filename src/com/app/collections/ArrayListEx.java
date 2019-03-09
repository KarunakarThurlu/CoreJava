package com.app.collections;

import java.util.Arrays;
import java.util.List;

public class ArrayListEx {
	public static void main(String[] args) {
		List<String> l=Arrays.asList("saritha","namitha","haritha","mamatha","kavitha","susmitha");
		l.stream().filter(s->s.startsWith("k")).forEach(System.out::println);
		l.stream().sorted((o1,o2)->o2.compareTo(o1)).forEach(s->System.out.print(s+" "));
		l.stream().reduce((o1,o2)->(o1.length()>o2.length())?o1:o2).ifPresent(s->System.out.println(s));
	}

}
