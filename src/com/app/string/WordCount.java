package com.app.string;

import java.util.Arrays;
import java.util.HashMap;

public class WordCount {

	public static void main(String[] args) {
		words("i am am learning java java");
	}

	public static void words(String s) {
		String str[] = s.split(" ");
		Arrays.stream(str).filter((a) -> a.equals(a)).forEach(a -> System.out.print(a + " "));
		HashMap<String, Integer> hm = new HashMap<>();
		for (String ss : str) {

			if (hm.get(ss) != null) {
				hm.put(ss, hm.get(ss) + 1);
			} else {
				hm.put(ss, 1);
			}

		}
		hm.keySet().stream().filter((hmm) -> hmm.length() >= 2).forEach((sm) -> System.out.println(sm));
		System.out.println(hm);
		
		String ss="    ftyt";
		System.out.println(ss);
		System.out.println(ss.trim());

	}
}

/*

Meeting title: Phone screen for karunakar thurlu, Software Development Engineer
Personalized ID: 5951752966
Meeting ID: 5951 75 2966
Hosting Region: Ireland
URL Link: https://chime.aws/5951752966
US dial-in: +1 206-462-5569
US toll-free dial-in: +1 855-552-4463
International dial-in numbers: https://chime.aws/dialinnumbers/

shisidhu@amazon.com
venukon@amazon.com
hire-scheduling@email.amazon.com
*/