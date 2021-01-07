package com.app.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class ComparableEx {
	
	/*
	 * 1). It is Functional Interface
	 * 2). It consists comapreTo(<T> t) abstract method.
	 * 3). Present in java.lang package.
	 * 4). It Can be used for Default Natural Sorting Order.
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		List<String> foos=Arrays.asList("Java","NodeJS","SpringBoot","React");
		
		//Default Natural Sorting Order
		Collections.sort(foos);
		System.out.println(foos);

		
		//Custom Sorting Order
		Collections.sort(foos,(f1,f2)->f2.compareTo(f1));
		System.out.println(foos);
		List<Foo> emps= new ArrayList<Foo>();
		Foo e1=new Foo(12,"joe",2600.00);
		Foo e2=new Foo(15,"jessi",2300.00);
		Foo e3=new Foo(14,"jhon",2400.00);
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		
		emps.forEach(e->System.out.println(e));
	}
	
}
class Foo implements Comparable<Foo>{

	private int id;
	private String name;
	private Double sal;
	
	public Foo() {
		super();
	}
	public Foo(int id, String name,  Double sal) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	@Override
	public int compareTo(Foo e) {
		return this.getSal().compareTo(e.getSal());
	}
	@Override
	public String toString() {
		return "Foo [id=" + id + ", name=" + name + ", sal=" + sal + "]";
	}
	

}
