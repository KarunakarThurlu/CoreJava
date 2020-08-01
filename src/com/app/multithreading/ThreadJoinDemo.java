package com.app.multithreading;


class JoinThreadEx extends Thread
{
	public static Thread mt;

	public void run()
	{
		try {
			mt.join();
		} 
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		for(int i=0;i<=10;i++) 
		{
			System.out.println("CHILD");
			
		}
	}
}
public class ThreadJoinDemo 
{
	public static void main(String[] args) throws InterruptedException 
	{
		JoinThreadEx t=new JoinThreadEx();
		JoinThreadEx.mt=Thread.currentThread();
		t.start();
		t.join();
		for(int i=0;i<=10;i++) 
		{
			System.out.println("MAIN");
		}
	}

}
