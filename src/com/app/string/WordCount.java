package com.app.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class WordCount {
	
	public static void main(String[] args) {
		words("i am am learning java java");
	}
	public static void words(String s) {
		String str[]=s.split(" ");
		Arrays.stream(str).filter((a)->a.equals(a)).forEach(a->System.out.print(a+" "));
		HashMap<String, Integer> hm=new HashMap<>();
		for(String ss :str) {
			
			if(hm.get(ss)!=null) {
				hm.put(ss, hm.get(ss)+1);
			}
			else {
				hm.put(ss,1);
			}
			
		}
		hm.keySet().stream().filter((hmm)->hmm.length()>=2).forEach((sm)->System.out.println(sm));
		System.out.println(hm);
		
	}
}
