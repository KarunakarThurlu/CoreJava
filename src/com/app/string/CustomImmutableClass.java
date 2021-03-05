package com.app.string;

public final class CustomImmutableClass {
	/*
	 * To Create Custom Immutable class we need to follow mainly three steps
	 * 
	 * 1). Make class as final
	 * 2). Make all variables as final, inside the class
	 * 3). Provide only Getters.
	 * 
	 */
	
	private final String name="";
	private final Integer id=0;
	private final Boolean isValid=false;
	
	
	public String getName() {
		return name;
	}
	public Integer getId() {
		return id;
	}
	public Boolean getIsValid() {
		return isValid;
	}
}
