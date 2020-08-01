package com.app.multithreading;

public class ThreadGroupDemo {

	public static void main(String[] args) 
	{	
		 // Threads in threadGroup that  already have higher priority won't be effected But for newly addedd threads this max priority is appicable.

		ThreadGroup g1=new ThreadGroup("FirstGroup");
		Thread t1=new Thread(g1,"first");
		Thread t2=new Thread(g1,"second");
		
		g1.setMaxPriority(3);
		Thread t3=new Thread(g1,"second");
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(t3.getPriority());
		/*output:-
		 *5
		 *5
		 *3
		 * 
		 */
	}
}
