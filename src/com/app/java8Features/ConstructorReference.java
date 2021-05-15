package com.app.java8Features;

import com.app.model.Employee;

@FunctionalInterface
interface Foo{
	public Employee foo(int empid,String empName);
}

public class ConstructorReference {
	
	public static void main(String[] args) {
		
		//=====By using Lambda====
		Foo f=(id,name)->new Employee(id,name);
		Employee e1= f.foo(12,"foo");
		System.out.println(e1);
		
		//====By using constructor reference====
		Foo ff=Employee::new;
		Employee e2 = ff.foo(2,"jo");
		System.out.println(e2);
	
	} 
}
