package com.app.model;

public class Employee  implements Comparable<Employee>{
	private int id;
	private String name;
	private Double sal;
	
	public Employee() {
		super();
	}
	public Employee(int id, String name,  Double sal) {
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
	public int compareTo(Employee e) {
		return this.getSal().compareTo(e.getSal());
	}
	
}
