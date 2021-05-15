package com.app.java8Features;

import java.util.List;
import java.util.Optional;

import com.app.model.Employee;

public class OptionalEx {
	/*
	 * * * Optional is a container type for a value which may be absent. * * * 
	 * =>To Avoid NullPointerException
	 */
	public static void main(String[] args) {
		/*
		 * Creating an Optional object
		 *
		 *1. Create an empty Optional :- An empty Optional Object describes the absence of a value.
		 *   Optional<Employee> employee = Optional.empty();
		 *
		 *2. Create an Optional with a non-null value:-
		 *
		 *   Employee employee = new Employee(1, "linda");
		 *   Optional<Employee> empOptional = Optional.of(employee);
		 *
		 *   Note:-If the argument supplied to Optional.of() is null, then it will throw a NullPointerException immediately and the Optional object won’t be created.
		 *
		 *3. Create an Optional with a value which may or may not be null:-If the argument passed to Optional.ofNullable() is non-null, then it returns an Optional containing the specified value, otherwise it returns an empty Optional.
		 *   Optional<Employee> empOptional = Optional.ofNullable(employee);
		 *
		 *4. Checking the presence of a value with some common methods
		 *
		 * (1). isPresent()
		         if(optional.isPresent()) {
    				// value is present inside Optional
    				System.out.println("Value found - " + optional.get());
				 } else {
    				// value is absent
    				System.out.println("Optional is empty");
				 }

	       (2). ifPresent()
	           optional.ifPresent(value -> {
    						System.out.println("Value found - " + value);
			   });

		   (3). get()
		   
		         Employee employee = optional.get()
		         
		   (4). orElse() 
		        Employee employee = optional.orElse(new Employee(0,"UnKnown User");
		 */


		//Example:-
		var l=List.of(new Employee(1,"karun"),new Employee(2,"varun"),new Employee(3,"tarun"),new Employee(4,"meanon"));
		Optional<Employee> optional= l.stream()
				.filter(e->e.getName().equals("karun"))
				.findAny();

		optional.ifPresent(System.out::println);
		optional.ifPresentOrElse(s->System.out.println(optional.get()) ,()->System.out.println("Emp not Found"));
		optional.orElseThrow(()->new RuntimeException("user not found"));
		optional.filter(e->e.getId()==1).ifPresent((e)->System.out.println(e));
		Employee e=optional.orElse(new Employee(0,"unknown user"));
        System.out.println(e);
	}
}
