package com.app.multithreading;

class MyThread extends Thread{
	public void run() {
		System.out.println("======Thread :"+Thread.currentThread().getName()+"=======");
	}
}

public class ThreadNameDemo {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		
		MyThread t=new MyThread();
		t.start();
		System.out.println(t.getName());
		
		Thread.currentThread().setName("Custom Thread ");
		
		System.out.println(Thread.currentThread().getName());
		
		System.out.println("Thread :"+Thread.currentThread().getName());
		System.out.println(10/0);
		
	}
}
