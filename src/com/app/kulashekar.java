package com.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class kulashekar {
	public static void main(String[] args) {
		/*int a=10;
		int c=a%2;
		int d=a/2;

		String UserName = null;
		System.out.println("helllo ?  "+UserName );
		System.out.println("karunakar"+"thurlu");
		System.out.println(100+"20");
		======Removing spaces in Given String======
		String str="karunakar yadav thurlu";
		String str2[]=str.split(" ");
		for(String i: str2) {
			System.out.print(i);
		}
		=====Finding duplicate numbers in array====
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
		 */
		String str1="harikahasini";
		String str2="aeiou";
		for(int i=0;i<str1.length();i++) {
			for(int j=0;j<str2.length();j++) {
				if(str1.charAt(i)==str2.charAt(j))
					str1=str1.replace(str1.charAt(i),'#');
			}
		}
		System.out.println(str1);
		String str="$"+10;
		System.out.println(Integer.parseInt(str.substring(1)));
		String str3="$"+20;
		int str4=Integer.parseInt(str.substring(1))+Integer.parseInt(str3.substring(1));
		System.out.println(str +"+"+str3+"=$"+str4);
	}
}
