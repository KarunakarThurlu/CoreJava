package com.app.string;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class DuplicateCharactersinString {
	@SuppressWarnings("unchecked")
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
		JSONObject obj=new JSONObject();
		str.chars().forEach(ch->{
			if(obj.containsKey((char)ch))
				obj.put((char)ch,(int)obj.get((char)ch)+1);
			else
				obj.put((char)ch, 1);
		});
		System.out.println(obj);
	}
}
