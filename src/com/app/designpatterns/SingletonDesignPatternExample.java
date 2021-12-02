package com.app.designpatterns;

import java.util.logging.Logger;
import java.util.stream.IntStream;

public class SingletonDesignPatternExample {
	private static final Logger log = Logger.getLogger(SingletonDesignPatternExample.class.getName());
	public static void main(String[] args) {
		IntStream.range(0, 10).forEach(k->{
			SingleToneInstoneInstance s=SingleToneInstoneInstance.getInstance();
			log.info(k+" "+s.getName()+" "+s.getFeild());
		});
	}	
}

class SingleToneInstoneInstance{
	private static final Logger log = Logger.getLogger(SingleToneInstoneInstance.class.getName());
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


	private static SingleToneInstoneInstance instance=null;

	private SingleToneInstoneInstance(String name, String feild) {
		super();
		this.name = name;
		this.feild = feild;
		log.info("Singletone constructor called!.");
	}


	public static SingleToneInstoneInstance getInstance() {
		if(instance==null) {
			instance=new SingleToneInstoneInstance("SingleToneInstoneInstance","singletone");
		}
		return instance;
	}
}