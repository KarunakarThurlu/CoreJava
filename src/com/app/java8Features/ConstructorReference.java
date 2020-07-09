package com.app.java8Features;

interface Foo{
	public Sample foo();
}
class Sample{
	Sample(){
		System.out.println("Sample Class Constructor");
	}
}
public class ConstructorReference {
	public static void main(String[] args) {
		
		//=====By using Lambda====
		Foo f=()->new Sample();
		f.foo();
		
		//====By using constructor referene====
		Foo f1=Sample::new;
		f1.foo();
	} 
}
