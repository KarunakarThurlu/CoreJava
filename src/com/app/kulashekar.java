package com.app;

import java.util.HashMap;
import java.util.Map;

public class kulashekar {
	public static void main(String[] args) {
		int a=10;
		int c=a%2;
		int d=a/2;

		String UserName = null;
		System.out.println("helllo ?  "+UserName );
		System.out.println("karunakar"+"thurlu");
		System.out.println(100+"20");
		//======Removing spaces in Given String======
		String str="karunakar yadav thurlu";
		String str2[]=str.split(" ");
		for(String i: str2) {
			System.out.print(i);
		}
		//=====Finding duplicate numbers in array====
		Map<Integer, Integer> map=new HashMap<>();
		int arr[]= {1,3,4,6,2,3,6,8,9};
		for(int i :arr) {
			if(map.containsKey(i)) {
				map.put(i,map.get(i)+1);
			}else {
				map.put(i,1);
			}
		}
		System.out.println(map);
		 
		String str1="harikahasini";
		String str3="aeiou";
		for(int i=0;i<str1.length();i++) {
			for(int j=0;j<str3.length();j++) {
				if(str1.charAt(i)==str3.charAt(j))
					str1=str1.replace(str1.charAt(i),'#');
			}
		}
		System.out.println(str1);
	}
}
