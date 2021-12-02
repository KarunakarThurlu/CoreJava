package com.app.string;

import java.util.HashMap;

public class FirstNonRepeatingCharacterinString {
	public static void main(String[] args) {
		String str = "abcqadajzbcedabdeagabcbdegbef";
		char firstNonRepeatingCharacter = firstNonRepeatingCharacter(str);
		System.out.println("First non-repeating character is " + firstNonRepeatingCharacter);
	}

	private static char firstNonRepeatingCharacter(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < str.length(); i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		for(int i = 0; i < str.length(); i++) {
			if(map.get(str.charAt(i)) == 1) {
				return str.charAt(i);
			}
		}
		return ' ';
	}
}
