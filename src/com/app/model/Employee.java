package com.app.model;

import java.util.HashSet;
import java.util.Set;

public class Employee {
	private Integer eid;
	private String ename;
	private Double esal;
	public Employee() {
		super();
	}
	public Employee(Integer eid, String ename, Double esal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + "]";
	}
	public static void main(String[] args) {
		Employee e1=new Employee(12,"abs",123.123);
		Employee e2=new Employee(12,"abs",123.123);
		Employee e3=new Employee(12,"abs",123.123);
		Set<Employee> s=new HashSet<>();
		s.add(e3);
		s.add(e1);
		s.add(e2);
        s.add(e3);//duplicate object
		System.out.println(s.size()+" "+s);
	}
}
