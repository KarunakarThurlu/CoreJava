package com.app.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.app.model.Player;

public class ComparableEx {
	
	public static void main(String[] args) {
		List<Player> p=Arrays.asList(
				new Player(100,"jessica"),
				new Player(200,"mosh"),
				new Player(400,"tony"),
				new Player(300,"foo"),
				new Player(200,"linda")
				);
		System.out.println("==========Before Sort==========");
		p.forEach(System.out::println);
         
		Collections.sort(p);
		System.out.println("==========After Sort===========");
		p.forEach(System.out::println);
	}
}
