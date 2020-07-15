package com.app.multithreading;

import java.util.stream.IntStream;

public class MultiThreadingExamples {
	

	public static void main(String[] args) {
		/*(1).Multitasking:- Executing multiple tasks simultaneously 
		 *   Multitasking is of two types: 1). Process based multitasking
		 *                                 2). Thread  based multitasking
		 * 
		 * 1). Process based multitasking:- Executing multiple tasks simultaneously where each task is separate independent (process)program. at OS level
		 * 2). Thread  based multitasking:- Executing multiple tasks simultaneously where each task is separate independent part of the same (process)program. at programming level 
		 * 
		 * The main advantage of these two concepts is To achieve high performance and reduce CPU utilization.
		 * 
		 * The main important areas of multithreading is multimedia graphics ,animations, VFX ,gaming and do develop web servers, application servers etc..
		 * 
		 * =====================" a Thread is nothing but process of executing"=========================
		 * 
		 *(2).Defining a thread:- We can thread in two ways
		 *                     1) Extending Thread class
		 *                     2) Implementing Runnable interface
		 *
		 *1) Extending Thread class:-
		class MyThread extends Thread
		{                       // 1). Defining Thread
			public void run() 
			{
				for(int i=0;i<=10;i++) 
				{
					System.out.println(i+" child thread    ");// 2). creating job
				}
			}
		}
		
		public class ThreadDemo
		{
			public static void main(String ...k) 
			{
		         MyThread t=new MyThread(); //3). Instatiating thread
		         t.start();                 //4). starting thread
		         
		         //t.run() it is just like normal method call
		    
		         for(int i=0;i<=10;i++) 
		         {
			       System.out.println(i+"  main thread   ");
		         }
		    }
		 }
	
		 * * * The main aim of multithreading is to achieve high performance and reduce CPU utilization
		 * 
		 * * * Important areas where exactly use multithreading Multimedia graphics,Animations,games and web servers ,application server.
		 * 
		 * case(i)  : Thread Schedular:-It is part of JVM,and it is responsible for schedule threads. If Multiple threads are waiting for execution those threads execution order will be decided by thread schedular.
		 *                             The order of execution of threads we con't predict it will decided by thread schedular it varying from JVM to JVM.
		 * 
		 * case(ii) : what is diff between t.start() and t.run()
		 *            when we are calling t.start() a new thread will be created for the execution of run method. first it will check thread impl class contains start() method or not ,if  not it will 'Thread' class start() this method internally call our impl calss run() method
		 * 			  When we are calling t.run()   a new thread won't created and run method  will execute just like normal method call by main thread. 
		 * case(iii): Importance of Thread class start(): thread class start() is responsible to register the thread with thread scheduler and all other mandatory activities hence without executing thread class start() method there no chance to start new thread in java due this thread class start() method is considered as heart of multi threading
		 *     
		 *            start()
		 *             {
		 *                1. Register this thread with thread scheduler
		 *                
		 *                2. perform all other mandatory activities 
		 *                
		 *                3. Invoke run() method
		 *             }
		 *
		 *case(iv) : Overloading of run() method: Overloading of run method is always possible but thread class start() method can invoke no-arg run() method the other overloaded method we have to call explicitly like a normal method call
		 *
		 *Ex:-
		 class MyThread extends Thread
		  {                      
			  public void run() 
			  {
			     System.out.println("no-arg run");
			  }
			  public void run(int i) 
			  {
			    System.out.println("int arg run");
			  }
		  } 
		
		  public class ThreadDemo
		  {
			public static void main(String ...k) 
			{
		         MyThread t=new MyThread(); 
		         t.start();                 
		    }
		  }
		  
		  Output: no-arg run
		 *
		 * case(v): if we not overriding run method() then thread class run() method will be executed which has empty implementation hence we won't get any output
		 *
		  Ex:
		  class MyThread extends Thread
		   {                      
			  
		   } 
		
		  public class ThreadDemo
		  {
			public static void main(String ...k) 
			{
		         MyThread t=new MyThread(); 
		         t.start();                 
		    }
		  }
		   output: <nothing>
		  
		
		  *Note: it is highly recommended to override run method otherwise don't go for multithreading concept 
		  * 
		  * 
		  * 
		  * case(vi) overring of start() method: if we override start() method then our start() method will be executed like normal method call and new thread won't be created
		  * 
		  * Ex:
		  class MyThread extends Thread
		  {                      
			  public void start() 
			  {
			     System.out.println("start method");
			  }
			  public void run() 
			  {
			    System.out.println(" run");
			  }
		  } 
		
		  public class ThreadDemo
		  {
			public static void main(String ...k) 
			{
		         MyThread t=new MyThread(); 
		         t.start(); 
		         System.out.println("main thread");                
		    }
		  }
		    
		   output: start method
		           main  thread//total out produced by main thread
		             
		   Note: It is not recommended to override start method other wise don't go for multi threading concept          
		 
		  case(v):
		  class MyThread extends Thread
		  {                      
			  public void start() 
			  {
			     super.start();
			     System.out.println("start method");
			  }
			  public void run() 
			  {
			    System.out.println(" run method");
			  }
		  } 
		
		  public class ThreadDemo
		  {
			public static void main(String ...k) 
			{
		         MyThread t=new MyThread(); 
		         t.start(); 
		         System.out.println("main method");                
		    }
		  }
		 output: possibility 1   possibility 2   possibility 3
		 
		         start Method    main method     run method
		         run Method      start method    main method
		         main Method     run method      start method
		   
		   
		  *case(vi) Thread Life cycle:
		  *
		  *   Mythread t=new MyThread()=====>  {t.start()} =====>  Ready/Runnable =====> {if T.S allocates processor} ====> Running =====> {if run() method completed}  ====>Dead     
		  *    (new or born)
		  *
		  *case(vii) After starting a thread if we are trying to restart the same thread again then we will get RE: IlligalThreadStateException
		  *
		  *Ex:
		   
		  class MyThread extends Thread
		  {                      
			  public void run() 
			  {
			    System.out.println(" run method");
			  }
		  } 
		
		  public class ThreadDemo
		  {
			public static void main(String ...k) 
			{
		         MyThread t=new MyThread(); 
		         t.start(); 
		         System.out.println("main method"); 
		         t.start();               
		    }
		  }
		  
		  output: RE:IlligalThreadStateException
		  *
		  *
		  *
		  *2). Defining a Thread by implementing Runnable interface: We can define a thread by implementing Runnable interface
		  * 
		  *    Runnable interface present in java.lang package and contains only one method that is 'public void run();'
		  *
		     Ex:-
		class MyRunnable implementing Runnable // 1). Defining a thread
		{                     
			public void run() 
			{
				for(int i=0;i<=10;i++) 
				{
					System.out.println(i+" child thread    ");// 2). creating job
				}
			}
		}
		
		public class ThreadDemo
		{
			public static void main(String ...k) 
			{
			     MyRunnable r=new MyRunnable();
		         Thread t=new Thread(r);    //3). Target Runnable
		         t.start();                 //4). starting thread
		    
		         for(int i=0;i<=10;i++) 
		         {
			       System.out.println(i+"  main thread   ");
		         }
		    }
		 }
		   
		   Case Study:
		   
		   MyRunnable r=new MyRunnable();
		   Thread t1=new Thread(); 
		   Thread t2=new Thread(r);  
		   
		   case(i)  : t1.start()
		                         a new Thread will be created and which is responsible for the execution of thread class run method, which has empty implementation
		   case(ii) : t1.run()
		                         No new Thread will be created and Thread class run() method will be executed just like a normal method call
		   case(iii): t2.start() 
		                         a new thread will be created which is responsible for the execution of myRunnable class run() method
		   case(iv) : t2.run()
		                         a new thread won't be created and MyRunnable run() will be executed just like a normal method call                   
		   case(v)  : r.start()
		                         we will get CE:can't find symbol  method location class location MyRunnable
		   case(vi) : r.run()
		                         No new Thread will be created and MyRunnable run() will be executed like normal method call                
		  *
		  *
		  * * * *Which approach is best to define a Thread: Among two ways of defining a thread implements Runnable approach is recommended.
	                                                        In 1st approach our class always extends Thread class,there is  no chance of extending any other class hence we are missing inheritance befit
	                                                        In 2nd approach while implementing Runnable interface we can extend any other class hence we won't miss inheritance benefit.
	                                                  
	                                                        B'z of above reason implementing Runnable approach is recommended then extending Thread class
		  * * * *
		  *
		  * Thread class Constructors:
		  *
		  *1). Thread t=new Thread()
		  *
		  *2). Thread t=new Thread(Runnable r)
		  *
		  *3). Thread t=new Thread(String name)
		  *
		  *4). Thread t=new Thread(Runnable r,String name)
		  *
		  *5). Thread t=new Thread(ThreadGroup r,String name)
		  *
		  *6). Thread t=new Thread(ThreadGroup r,Runnable  r)
		  *
		  *7). Thread t=new Thread(ThreadGroup r,Runnable r,String name)
		  *
		  *8). Thread t=new Thread(ThreadGroup r,Runnable r,String name,long stacksize)
		  *
		  *
		  * * * *Getting and setting Name of a Thread:-
		  *                                             Every Thread in java has some name it may be default name generated by JVM or Customized name provided by programmer.
		  *                                             we can get and set name of a thread by using the following two methods of thread class
		  *												
		  * 										 1). public final String getName()
		  *                                          2). public final void setName(String name)
		  *
		     Ex:
		            class MyThread extends Thread
		            {
	
                    }

                    public class ThreadNameDemo 
                    {
	
	                      public static void main(String[] args) 
	                      {
		                            System.out.println(Thread.currentThread().getName());
		
	                   				MyThread t=new MyThread();
		
									System.out.println(t.getName());
		
									Thread.currentThread().setName("Custom Thread ");
		
								    System.out.println(Thread.currentThread().getName());
		
									System.out.println(10/0);
	                       }
                      } 

		  *
		  *Note: we can get current executing thread object by using "Thread.currentThread().getName();"
		  * 
		  * 
		  * 
		  * 
		  *Thread Priorities(1-10):-
		  *================== 
		  *                    Every Thread in java has some priority it may be default priority generated by JVM or Customized priority by programmer. The valid range of Thread priorities is 1 to 10 where 1 MIN_PRIORITY ,10 is MAX_pRIORITY.
		  *                    Thread class defines the following constants to represents some standard priorities
		  *                    
		  *                    Thread.MIN_PRIORITY=====>1
		  *                    Thread.NORM_PRIORITY====>5
		  *                    Thread,MAX_PRIORITY=====>10
		  *                    
		  * * *The Thread scheduler will use priorities while allocating processor
		  * * *The Thread which is having highest priority will get chance first
		  * * *If two threads having same priorities then we can't expect exact execution order it depends on thread scheduler
		  * 
		  *
		  *we can get and set thread priorities using in the following methods
		  *
		  * ===>public final int getPriority()
		  * 
		  * ===>public final void setPriority(int i)
		  *                                    
		  * Range is 1 to 10 other wise RE:IlligalArgumentException
		  * ex:
		  *   t.setPriority(7); //Valid
		  *   t.setPriority(17); RE:IlligalArgumentException
		  *
		  *Default Priority:-
		  *================
		  *                  The default priority only for the main thread is 5 but for all remaining threads default priority will be inherited from parent to child that is what ever priory parent thread has the same priority will be there for the child thread
		  *
		  *
		   public class ThredPrioritesDemo 
		   {
	           public static void main(String[] args)
	            {		
		 			IntStream.range(1, 11).forEach(s->System.out.println(s+"   main thread priority :"+Thread.currentThread().getPriority()));
					Runnable r=()->IntStream.range(1, 11).forEach(s->System.out.println(s+"  Child thread priority :"+ Thread.currentThread().getPriority()));
					Thread.currentThread().setPriority(7);// if we comment this line then child thread priority will become 5
					Thread t=new Thread(r);		
				    t.start();	
		        }
			}		
		  */
 
		
	}
}
