package com.app.model;

public class Employee   {
	private int id;
	private String name;
		
	
	public Employee() {
		super();
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this)
			return true;
		if(obj instanceof Employee) {
			Employee e=(Employee) obj;
			if(name.equals(e.getName()) && id==e.getId()) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "{ id : " + id + ", name : " + name+" }";
	}
	 
	/*@Override
	public boolean equals(Object obj) {
		try {
			Employee e=(Employee) obj;
			if(name.equals(e.getName()) && id==e.getId()) {
				return true;
			}else {
				return false;
			}
		} catch (ClassCastException e) {
			return false;
		} catch(NullPointerException e) {
			return false;
		}
	}*/
	
}
