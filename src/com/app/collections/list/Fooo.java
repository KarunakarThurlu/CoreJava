package com.app.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Fooo {
	public static void main(String[] args) {

		Emp e1 = new Emp();
		e1.setId(2);
		e1.setName("Foo2");
		Emp e2 = new Emp();
		e2.setId(1);
		e2.setName("foo1");

		List<Emp> emps = new ArrayList<>();
		emps.add(e1);
		emps.add(e2);
		System.out.println(emps);

		Set<Integer> i = new TreeSet<>();

	}

}

class Emp {

	private int id;
	private String name;

	public Emp() {
		super();
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

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}

}
