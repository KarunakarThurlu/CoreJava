package com.app.string;

import java.util.Arrays;
import java.util.Comparator;

import com.app.model.Player;

public class ComparatorEx{

	public static void main(String[] args) {

		Player[] players = {
				new Player(100,"jessica"),
				new Player(200,"mosh"),
				new Player(400,"tony"),
				new Player(300,"foo"),
				new Player(200,"linda")
		};

		Comparator<Player> p=(p1,p2)->{
			if(p1.score-p2.score==0)
				return p1.name.compareTo(p2.name);
			else
				return p1.score-p2.score;		
		};

		System.out.println("==========Before Sorting==============");
		Arrays.stream(players).forEach(plr->System.out.println(plr.score+" "+plr.name));

		Arrays.sort(players,p);

		System.out.println("==========After Sorting===============");

		Arrays.stream(players).forEach(s->System.out.println(s.score+" "+s.name));

	}   
}
/*Example1:-Sort employee objects based on empNames.
 *Constraint:- If Two employee objects has same Employee Name sort based on employeeId.
public static void main(String[] args) {
		var list=Arrays.asList(new Employee(1, "Karun"),
				new Employee(3, "Tarun"),
				new Employee(5, "Varun"),
				new Employee(4, "Jevan"),
				new Employee(2, "Varun")
				);
		Comparator<Employee> compator=(e1,e2)->{
			if(e1.getName().compareTo(e2.getName())==0)
				return e1.getId()-e2.getId();
			else
				return e1.getName().compareTo(e2.getName());
		};
		Collections.sort(list, compator);
		set.forEach(System.out::println);
	}
*/