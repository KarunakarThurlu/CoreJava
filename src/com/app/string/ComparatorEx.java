package com.app.string;

import java.util.Arrays;
import java.util.Comparator;

import com.app.model.Player;

public class ComparatorEx{

	public static void main(String[] args) {

		Player[] emps = {
				new Player(100,"jessica"),
				new Player(200,"mosh"),
				new Player(400,"tony"),
				new Player(300,"foo"),
				new Player(200,"linda")
		};

		Comparator<Player> e=(e1,e2)->{
			if(e1.score-e2.score>0)
				return e1.score-e2.score;
			else
				return e1.name.compareTo(e2.name);		
		};

		System.out.println("==========Before Sorting==============");
		Arrays.stream(emps).forEach(p->System.out.println(p.score+" "+p.name));

		Arrays.sort(emps,e);

		System.out.println("==========After Sorting===============");

		Arrays.stream(emps).forEach(s->System.out.println(s.score+" "+s.name));

	}   
}
