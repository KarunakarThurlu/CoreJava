package com.app.string;

import java.util.HashMap;

public class DuplicateCharactersinString {
	
	public static void main(String[] args) {
		String str="harikahasini";
		char c[]=str.toCharArray();
		HashMap<Character, Integer> map=new HashMap<>();
		for(char i: c) {
			if(map.containsKey(i)) {
				map.put(i,map.get(i)+1);
			}else {
				map.put(i,1);
			}
		}
		System.out.println(map);
	}
}
