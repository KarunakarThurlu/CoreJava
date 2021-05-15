package com.app.java8Features;


/*1). A method reference is the shorthand syntax for a lambda expression that executes just ONE method.
 *2). Lambda expressions & Method references are working because of functional interfaces.
 *3). With out functional interfaces it is not possible to use lambdas & method references.
 * syntax:-
 * =======
 *   instance method reference ----> referenveVariable::methodName
 *   static   method reference ----> className::methodName
 *   
 */
@FunctionalInterface
interface foo{
	int doSum(int a,int b);
}
public class MethodReference {
	public static void main(String[] args) {
		foo m=MethodReference::doSum;
		System.out.println(m.doSum(12, 124)); 
	}
	public static  int doSum(int a,int b) {
		return a+b;
	}
}

//Example1:-instance method reference

/*
@FunctionalInterface
interface foo{
	int doSum(int a,int b);
}
public class MethodReference {
	public static void main(String[] args) {
		MethodReference f=new MethodReference();
		foo m=f::doSum;
		System.out.println(m.doSum(12, 12)); 
	}
	public int doSum(int a,int b) {
		return a+b;
	}
}
*/

//Example2:static   method reference
/*
@FunctionalInterface
interface foo{
	int doSum(int a,int b);
}
public class MethodReference {
	public static void main(String[] args) {
		foo m=MethodReference::doSum;
		System.out.println(m.doSum(12, 124)); 
	}
	public static  int doSum(int a,int b) {
		return a+b;
	}
}
 */
