package com.app.collections;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
	public static void main(String[] args) {
		Map<String,String> m=new HashMap<>();
		m.put("karun","jhansi");
		m.put("Emma","Britan");
		m.put("Dayana","UK");
		m.put("smith","US");
		m.put("Loha", "US");
		m.put("jessika","Canada");
		m.entrySet().stream().filter(s->s.getKey().startsWith("k")).forEach(s->System.out.println(s));
		
		System.out.println(m.size());
		
	}
}
