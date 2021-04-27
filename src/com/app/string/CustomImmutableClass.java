package com.app.string;

public final class CustomImmutableClass {
	/*
	 * To Create Custom Immutable class we need to follow mainly three steps
	 * 
	 * 1). Make class as final
	 * 2). Make all variables as final, inside the class
	 * 3). Provide only Getters.
	 * 
	 *****Once we create an object we can't perform any changes on that object, if anything changes in that object with those changes a new object will be created. if there is no change in the content then  existing object will be reused. This behavior is nothing but immutability.
	 * String s1="foo";
	 * String s2=s1.toUpperCase();//here new object created
	 * String s3=s1.toLowerCase();//here existing object reused.
	 * 
	 * final class Test{
	 *  int i;
	 *  Test(int i){
	 *    this.i=i;
	 *  }
	 *  public Test modify(int i){
	 *    if(this.i==i){
	 *      return this;
	 *    }else{
	 *      return new Test(i);
	 *    }
	 *  }
	 * }
	 * 
	 * 
	 * Test t1=new Test(10);
	 * Test t2=t1.modify(20);
	 * Test t3=t1.modify(10);
	 * 
	 * print(t1==t2);//false
	 * print(t1==t3);//true
	 *****
	 *
	 *
	 *********final Vs immutability**************
	 * final applicable for variables but not for objects where as immutability applicable for objects but not for variables.
	 * By declaring a reference variable as final we won't get any immutability nature. Even though reference variable is final we can perform any type of changes in the corresponding changes in that object, but we can't perform reassignment for that variable.
	 * Hence final and immutable both are different concepts.
	 * Ex:-
	 * === final StringBuffer sb=new StringBuffer("foo");
	 *                        sb.append("bar");
	 *                        print(sb);
	 *                        output:foobar
	 *                        sb=sb.append("zooo");//CE: final variable can't assign.
	 *                        
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
