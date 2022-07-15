package com.app.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	public static void main(String[] args) {
		groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
	}
	
	public static void groupAnagrams(String[] a) {
	 Map<String, List<String>> res = new HashMap<>();
	 for(int i=0;i<a.length;i++) {
		 char[] s=a[i].toCharArray();
		 Arrays.sort(s);
		  if(res.containsKey(new String(s))) {
			  res.get(new String(s)).add(a[i]);
		  }else {
			  res.put(new String(s),new ArrayList<>());
			  res.get(new String(s)).add(a[i]);
		  }
	 }
	 System.out.println(res);
	}
}
