package com.app.multithreading;

class Display
{
	public   void wish(String name) 
	{
		for(int i=0;i<=10;i++)
		{
			System.out.print("Hai Hello!........");
			try 
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(name);
		}		
	}
}

class DisplayThread extends Thread
{
	Display d;
	String n;
	public DisplayThread(Display d, String n) 
	{
		super();
		this.d = d;
		this.n = n;
	}
	public void run()
	{
		d.wish(n);
	}	
}

public class SynchronizedDemo
{
	public static void main(String[] args)
	{
		Display d=new Display();
		DisplayThread t1=new DisplayThread(d,"TONY");
		DisplayThread t2=new DisplayThread(d,"NIHARIKA");
		t1.start();
		t2.start();
	}
}

/*
 * 
Example2:-
========
class Display

{
	public synchronized void wish(String name)
	{
		for(int i=0;i<=10;i++) 
		{
			System.out.print("Hai Hello!........");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e)
			{

				e.printStackTrace();
			}
			System.out.println(name);
		}

	}
}

class DisplayThread extends Thread
{
	Display d;
	String n;
	public DisplayThread(Display d, String n)
	{
		super();
		this.d = d;
		this.n = n;
	}
	public void run() 
	{
		d.wish(n);
	}

}

public class SynchronizedDemo 
{
	public static void main(String[] args)
	{
		Display d1=new Display();
		Display d2=new Display();
		DisplayThread t1=new DisplayThread(d1,"TONY");
		DisplayThread t2=new DisplayThread(d2,"NIHARIKA");
		t1.start();
		t2.start();

	}
}
*/

/*
 * Example3:-
 * ========
class Display
{
	public synchronized void wish()
	{
		for(int i=0;i<=10;i++) 
		{
			System.out.print(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{				
				e.printStackTrace();
			}
		}
	}
		public synchronized void wishc()
		{
			for(int i=65;i<=75;i++) 
			{
				System.out.print((char)i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e)
				{					
					e.printStackTrace();
				}
			}
		
	}
}

class DisplayThread1 extends Thread
{
	Display d;
	String n;
	public DisplayThread1(Display d)
	{
		super();
		this.d = d;	
	}
	public void run() 
	{
		d.wish();
	}
}
class DisplayThread2 extends Thread
{
	Display d;
	String n;
	public DisplayThread2(Display d)
	{
		super();
		this.d = d;	
	}
	public void run() 
	{
		d.wishc();
	}
}

public class SynchronizedDemo 
{
	public static void main(String[] args) 
	{
		Display d=new Display();
		DisplayThread1 t1=new DisplayThread1(d);
		DisplayThread2 t2=new DisplayThread2(d);
		t1.start();
		t2.start();

	}
}*/

/*
 * Example of synchronized block;-
 * ================================
class Display
{
	public   void wish(String name) 
	{
		;;;;;;;;;;;;//10 thlines of code
		synchronized (this) 
		{
		  for(int i=0;i<=10;i++)
		  {
			System.out.print("Hai Hello!........");
			try 
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(name);
		   }	
		}
		;;;;;;;;;;;;//10 thlines of code
	}
}

class DisplayThread extends Thread
{
	Display d;
	String n;
	public DisplayThread(Display d, String n) 
	{
		super();
		this.d = d;
		this.n = n;
	}
	public void run()
	{
		d.wish(n);
	}	
}

public class SynchronizedDemo
{
	public static void main(String[] args)
	{
		Display d=new Display();
		DisplayThread t1=new DisplayThread(d,"TONY");
		DisplayThread t2=new DisplayThread(d,"NIHARIKA");
		t1.start();
		t2.start();
	}
}*/
