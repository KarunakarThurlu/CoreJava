package com.app.string;

import java.util.HashMap;
import java.util.function.IntConsumer;

import org.json.simple.JSONObject;

public class DuplicateCharactersinString {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String str="harikahasini";
		
		//=============Before JDK1.8==========
		
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
		
		//=============Using JDK1.8============
		
		JSONObject obj=new JSONObject();

		IntConsumer action=ch->{
			if(obj.containsKey((char)ch))
				obj.put((char)ch,(int)obj.get((char)ch)+1);
			else
				obj.put((char)ch, 1);
		};
		str.chars().forEach(action);
		System.out.println(obj);
	}
}
