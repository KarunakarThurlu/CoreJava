package com.app.java5Features;

import java.util.Arrays;

public class VarArgsEx {
	/*1).Variable arguments parameter(varargs) was introduced in JDK1.5
	 *2).Syntax:- (i)  methodName(<T>  ...variableName)
	 *            (ii) methodName(<T>...  variableName)
	 *            (iii)methodName(<T> ... variableName)
	 *3).There can be only one variable argument in a method.           
	 *4).if method has more than two parameters variable_argument  must be last parameter. 
	 *   Example:-(i) foo(int ...a,int ...b)    ===> InValid
	 *           (ii) foo(String... a,int ...b) ===> InValid
	 *           (iii)foo(int a,int ... b)      ===> Valid
	 *           (iV) foo(int ...a,int b)       ===> InValid
	 *5).Overloading is possible for variable argument parameter methods 
	 */
	public static void main(String ... variable_arguments_parameter){
	   foo();
	   foo(10,20);
	   foo(10,20,30);
	   foo(10,20,30,40);
	   
	   foo(10,"foo");
	   foo(20,"foo","zoo");
	}
	public static void foo(int ...varargsArrayVariable) {
		System.out.println("Variable Argument parameter of length : "+varargsArrayVariable.length);
		System.out.println(Arrays.stream(varargsArrayVariable).sum()); 
	}
	public static void foo(int firstParameter,String ...varargsArrayVariable) {
		System.out.print("First Parameter is : "+firstParameter+" Variable Argument parameter of length : "+varargsArrayVariable.length);
		System.out.println();
		Arrays.stream(varargsArrayVariable).forEach(System.out::println); 
	}
}
