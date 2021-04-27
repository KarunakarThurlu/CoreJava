package com.app.java8Features;

import java.util.Optional;

import com.app.model.Employee;

public class OptionalEx {
  /*
   * To Avoid NullPointerException
   * 
   */
	public static void main(String[] args) {
		Employee e=new Employee();
		e.setName("Jessika");
		Optional<Employee> oe=Optional.<Employee>of(e);
	    if(oe.isPresent())
	    	Optional.ofNullable(oe.get().getName()).ifPresentOrElse(s->System.out.println(s),()->System.out.println("Emp name is  null"));
 	    else
	    	System.out.println("not Found");
	}
}
