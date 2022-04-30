package com.app.string;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.HashMap;
import java.util.Map;

public class CharCount {
	
	private static Logger logger = System.getLogger(CharCount.class.getName());
	
	public static void main(String[] args) {
		String s="kulasekhar";
		for(char c='a';c<='z';c++)
		{
			int count=0;
			for(int j=0;j<s.length();j++)
			{
				if(s.charAt(j)==c)
					count++;
			}
			if(count>0)
				logger.log(Level.INFO,"{0} = {1}",c,count);
		}
		
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			if(map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			else
				map.put(s.charAt(i),1);
		}
		logger.log(Level.INFO, map);
	}
}
