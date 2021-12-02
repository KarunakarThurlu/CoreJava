package com.app.string;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestSubstringWithOutDuplicatesChars {

	public static String getStringFromSetOfCharacters(Set<Character> set) {
		return set
				.stream()
				.map(String::valueOf)
				.collect(Collectors.joining());	
	}
	public static String longestStringInList(List<String> list) {
		return 	list
				.stream()
				.reduce((s1,s2)->s1.length()>s2.length()?s1:s2)
				.orElse("Nonce");
	}
	public static String longestSubstringWithoutDuplicate(String input) {
		Set<Character> set = new LinkedHashSet<>();
		List<String> list=new LinkedList<>();
		int length=input.length();
		int i=0,j=1;
		while(i<length ) {
			if(set.contains(input.charAt(i))){
				String currentresult=getStringFromSetOfCharacters(set);
				list.add(currentresult);
				set.clear();
				set.add(input.charAt(i));  
				i=j;
				j++;
			}else{
				set.add(input.charAt(i));
			}
			i=i+1;
			
		}
		list.add(getStringFromSetOfCharacters(set));
		System.out.println(list);
		return longestStringInList(list);
	}

	public static void main(String[] args) {
		String str = "aqwertaqyuiobcadajbcedabdeagabcbdegbef";
		System.out.println(longestSubstringWithoutDuplicate(str));
	}  
}
