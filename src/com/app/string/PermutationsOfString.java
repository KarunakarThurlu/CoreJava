package com.app.string;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;

public class PermutationsOfString {

	private static final Logger logger = System.getLogger(PermutationsOfString.class.getName());
	static List<String> l = new ArrayList<>();

	public static void main(String[] args) {
		permutations("ABCD","");
		logger.log(Level.INFO,l);
	}

	public static List<String> permutations(String src,String permutation) {
		if(src.isBlank()) 
			l.add(permutation);
		else 
			for (int i=0;i<src.length();i++) {
				char currentChar = src.charAt(i);
				String newString = src.substring(0,i)+src.substring(i+1);
				permutations(newString,permutation+currentChar);
			}

		return l;
	}
}
