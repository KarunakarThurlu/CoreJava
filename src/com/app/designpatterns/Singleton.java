package com.app.designpatterns;

public class Singleton {
	public static void main(String[] args) {
		for(int i=0;i<=10;i++) {
			SingleToneInstoneInstance s=SingleToneInstoneInstance.getInstance();
			System.out.println(i+" "+s.getName()+" "+s.getFeild());
		}
	}	
}

class SingleToneInstoneInstance{
	String name="";
	String feild="";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getFeild() {
		return feild;
	}

	public void setFeild(String feild) {
		this.feild = feild;
	}


	private static SingleToneInstoneInstance instance;

	private SingleToneInstoneInstance(String name, String feild) {
		super();
		this.name = name;
		this.feild = feild;
		System.out.println("Singletone calss called");
	}


	public static SingleToneInstoneInstance getInstance() {
		if(instance==null) {
			instance=new SingleToneInstoneInstance("SingleToneInstoneInstance","singletone");
		}
		return instance;
	}
}