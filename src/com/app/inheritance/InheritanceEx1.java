package com.app.inheritance;


class Parent
{
	int i=10;
	public void show()
	{
		System.out.println("Parent Method");
	}
}
class Child extends Parent
{
	int i=20;
	public void show()
	{
		System.out.println("Child Method");
	}
}
public class InheritanceEx1 {
	
	public static void main(String[] args) {
		Parent p=new Child();
		p.show();
		System.out.println(p.i);
	}
}
