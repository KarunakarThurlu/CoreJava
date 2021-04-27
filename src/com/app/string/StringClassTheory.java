package com.app.string;

public class StringClassTheory {
	/*
	 *1). String is most Commonly used Data type in java.
	 *2). String is immutable class(modifications are not allowed).
	 *3). If you are trying to modify String content a separate object will be created and reference will be pointed to that newly created object.
	 *4). ******String class Overrides equals method for content comparison********
	 *5). We can't Compare(==) String class Objects with  any Other(StringBuffer,StringBuilder) other wise we will get incompatible error.
	 *6). String s=new String("foo"); //in this case two objects will be created one in heap another in SCP.
	 *7). String s="foo";// Here only one object created in SCP.
	 *8). Object creation in SCP is always optional. first JVM will check is there any object is in SCP with same content, if present then reused else create new object. this rule is for SCP but not for Heap.
	 *9). Garbage Collector not allowed to access SCP Area. hence even though objects dosn't contain reference not applicable for  Garbage Collector.
	 *10).***********All SCP Objects Will be destroyed automatically at the time JVM Shout down.*******************
	 *11). When ever we using new operator definitely a new object will be created in heap area. then there is  a chance of two objects with same content  in heap area but not in SCP.(i.e Duplicate Objects are possible in heap but in SCP).
	 *12).***********B'z of runtime operation if there is a change in the content then with those changes a new object will be created on the heap.if there is no changes in the content then existing object will be reused and new object won't be created.Weather the object present in heap or SCP the rule is same.
	 *13). Ex:- String s1=new String("foo");
	 *          String s2=s.toUpperCase();
	 *          String s3=s.toLowerCase();
	 *          print(s1==s2);//false
	 *          print(s1==s3);//true
	 *14).
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 */
	public static void main(String[] args) {
		String s=new String("foo");
		s.concat("foo");
		StringBuffer sb=new StringBuffer("foo");
		sb.append("foo");
		System.out.println(s);
		System.out.println(sb);
		

	}
}
