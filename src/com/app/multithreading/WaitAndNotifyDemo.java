package com.app.multithreading;

class ThreadA extends Thread{
	int total=0;
	public void run()
	{
		synchronized (this) 
		{
			System.out.println("Child thread got chance to perform logic");
			for(int i=1;i<=100;i++)
			{
				total=total+i;
			}
			System.out.println("Child given notification call");
			this.notify();
		}
	}
}
public class WaitAndNotifyDemo 
{
	public static void main(String[] args) throws InterruptedException 
	{
		ThreadA t=new ThreadA();
		t.start();
		synchronized (t) 
		{
			System.out.println("Main Thread calling wait method");
			t.wait();
			System.out.println("Main Thread got notification");
			System.out.println(" total "+t.total);
		}
	}
}
/*output:-
Main Thread calling wait method
Child thread got chance to perform logic
Child given notification call
Main Thread got notification
 total 5050
*/