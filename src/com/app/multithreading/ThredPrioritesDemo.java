package com.app.multithreading;

import java.util.stream.IntStream;

public class ThredPrioritesDemo {
	
	public static void main(String[] args) {
		
		IntStream.range(1, 11).forEach(s->System.out.println(s+"   main thread priority :"+Thread.currentThread().getPriority()));
		Runnable r=()->IntStream.range(1, 11).forEach(s->System.out.println(s+"  Child thread priority :"+ Thread.currentThread().getPriority()));
		//Thread.currentThread().setPriority(7);// if we comment this line then child thread priority will become 5
		Thread t=new Thread(r);		
		t.start();
		t.setPriority(10);
		IntStream.range(1, 11).forEach(s->System.out.println(s+"   main thread priority :"+Thread.currentThread().getPriority()));

		
	}

}
