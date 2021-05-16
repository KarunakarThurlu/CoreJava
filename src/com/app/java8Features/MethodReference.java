package com.app.java8Features;

import java.util.Arrays;
import java.util.List;


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


//Example3:-

/*

class Test {

	public static void main(String[] args) {

		List<Integer> list=Arrays.asList(1,2,3,4,6,5,7,9,8,10);

		System.out.println(list.stream()
				.filter(Test::isGT5)
				.filter(Test::isEven)
				.map(Test::doubleIt)
				.findFirst());

	}
	public static boolean isGT5(int number) {
		return number>3;
	}
	public static boolean isEven(int number) {
		return number%2==0;
	}
	public static int doubleIt(int number) {
		return number*2;
	}
}

*/