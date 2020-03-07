package com.app.arrays;

import java.util.HashMap;
import java.util.Map;

public class DuplicateElementsInArray {
	public static void main(String[] args) {
		findDuplicateElements(new int[] {12,3,4,5,6,7,8,2,3,4,5});
	}
	private static void findDuplicateElements(int[] input) {
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i:input) {
			if(map.containsKey(i))
				map.put(i,map.get(i)+1);
			else
				map.put(i,1);
		}
		map.entrySet().forEach(m->System.out.println(m.getKey()+" repetes "+ m.getValue()+" times"));
	}
}
