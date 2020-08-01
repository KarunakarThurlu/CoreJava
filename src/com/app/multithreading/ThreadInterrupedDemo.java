package com.app.multithreading;

class ThreadInterrupted extends Thread
{
	public void run() 
	{	
		try 
		{
			for(int i=0;i<=10000;i++) 
			{
				System.out.println("Lazy Thread");
				
			}
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			System.out.println(" i got interrupted");
		}
	}
}

public class ThreadInterrupedDemo 
{	
	public static void main(String[] args) 
	{
		ThreadInterrupted t=new ThreadInterrupted();
		t.start();
		//t.interrupt();
		System.out.println("main END");
	}
}
