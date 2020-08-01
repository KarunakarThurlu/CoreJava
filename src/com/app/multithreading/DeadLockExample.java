package com.app.multithreading;
class DeadLockClz1
{
	public synchronized void foo1(DeadLockClz2 d)
	{
		System.out.println("Thread1 starts execution of foo1 method");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread1 trying to call DeckLockClz2 lastmethod");
		d.last();
	}
	public synchronized void last()
	{
	 System.out.println("inside DeadLockClz1 last method");
	}
}
class DeadLockClz2
{
	public synchronized void foo1(DeadLockClz1 b)
	{
		System.out.println("Thread2 starts execution of foo1 method");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread2 trying to call DeckLockClz1 lastmethod");
		b.last();
	}
	public synchronized void last()
	{
		 System.out.println("inside DeadLockClz2 last method");
	}
}
public class DeadLockExample extends Thread
{
	DeadLockClz1 l1=new DeadLockClz1();
	DeadLockClz2 l2=new DeadLockClz2();
	public void m1()
	{
		this.start();
		l1.foo1(l2); //this line executed by main thread
	}
	public void run()
	{
		l2.foo1(l1);// this line executed by child Thread
	}
	public static void main(String[] args)
	{
		DeadLockExample e=new DeadLockExample();
		e.m1();
		
	}
}
/*output:- Thread1 starts execution of foo1 method
Thread2 starts execution of foo1 method
Thread1 trying to call DeckLockClz2 lastmethod
Thread2 trying to call DeckLockClz1 lastmethod
|
*/
