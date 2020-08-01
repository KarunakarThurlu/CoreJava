package com.app.multithreading;



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
		 *   MyThread t=new MyThread()=====>  {t.start()} =====>  Ready/Runnable =====> {if T.S allocates processor} ====> Running =====> {if run() method completed}  ====>Dead     
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
		 * 										    1). public final String getName()
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
		 *
		 *
		 *Note:-
		 *=====
		 *      Some platforms won't provide proper support for thread priorities
		 *
		 *
		 *
		 *
		 *
		 *Yield():-     public static native void yield();
		 *=========
		 *           # Yield method causes to pause current  executing thread to give chance for waiting threads of same priority.
		 *           # If  there is no waiting thread or all waiting threads have low priority then same thread can continue its execution.
		 *           # If multiple threads are waiting with same priority then which waiting thread will get chance we can't expect it depends on thread scheduler.
		 *           # The Thread which is yielded , when it get chance once again it depends on thread scheduler and we can't expect exactly.
		 *
		 *  	                                     					<=============Thread.yeild()<===========================|					    
		 *                                                             ||                                                      ||
		 *  MyThread t=new MyThread()=====>  {t.start()} =====>  Ready/Runnable =====> {if T.S allocates processor} ====> Running =====> {if run() method completed}  ====>Dead     
		 *   (New/Born)
		 *   
		  Yield() method Example:-
		  =======================
		  class MyThread extends Thread
		  {                      
			  public void run() 
			  {
			    for(int i=0;i<=10;i++)
			    {
			      System.out.println("child thread");
			      Thread.yeild();//=====>(1)
			    }
			  }
		  } 

		  public class ThreadDemo
		  {
			public static void main(String ...k) 
			{
		         MyThread t=new MyThread(); 
		         t.start(); 
		         for(int i=0;i<=10;i++)
			     {
			       System.out.println(" Main method");
			     }            
		     }
		  }

		 *
		 * In the above program if we commenting line 1 both threads will be executed simultaneously and we can't expect which thread will complete first.
		 * If we are not commenting line 1 then child thread always calls yield() B'z of that main thread will get chance more number of times and the chance of completing main thread first is high.
		 *
		 * * *Some platforms won't provide proper support for yield() method. 
		 *
		 *Join():-           1). public final void join() throws InterruptedException;
		 *========           2). public final void join(long ms) throws InterruptedException;
		 *                   3). public final void join(long ms,int ns) throws InterruptedException;
		 *         If a Thread wants to wait until completing some other thread then we should go for join() method.
		 *         For example if thread t1 wants to wait until completing t2 then t1 has to call t2.join(); 
		 *         if t2 executes t2.join() then immediately t1 will be entered into waiting state until t2 completes.
		 *         once t2 completes then t1 can continue its execution.
		 *
		 *         DBConnetion(t1)             QueryExecution(t2)              ReturnDataToBrowser(t3)
		 *             ||                            ||  							    ||
		 *             ||							 ||                                 ||
		 *             ||                            ||                                 ||
		 *			   ||                            ||                                 t2().join();
		 *             ||                            t1.join();                         ||
		 *             ||                            ||                                 ||
		 *             ||
		 *             ||
		 *             
		 *            QueryExecution(t2) has to wait until DBConnetion(t1) completion hence t2 has to call t1.join()
		 *            ReturnDataToBrowser(t3) has to wait until QuryExecution(t2) completion hence t3 has to call t2.join();
		 *
		 *Note : Every join() method throws interrupted exception which is checked exception hence compulsory we should handle this exception either by using try catch or by throws key word otherwise we will get compile time error.
		 *
		 *
		 *
		 *
		 * 
		 *                                     
		 *                                                           	<=====================Waiting state(Blocked for Joining)<======================
		 *                                     						   ||																			  ||
		 *                                if t2 completes (or) t2 time expires (or) waiting thread got interrupted	       t2.join(); (or) t2.join(1000); (or) t2.join(1000,100);
		 *                                     						   ||																			  ||
		 *                                                             ||                                                                             ||
		 *  MyThread t=new MyThread()=====>  {t.start()} =====>  Ready/Runnable ==================> {if T.S allocates processor} ================> Running =====> {if run() method completed}  ====>Dead     
		 *   (New/Born)
		 *
		 *
		 *
		 *Case(i):-waiting of  main thread until completing child thread below example
		 *=========

		     class JoinThread extends Thread
             {
	             public void run()
                	{
						for(int i=0;i<=10;i++) 
					    {
							System.out.println("NIHARIKA");
						try {
								Thread.sleep(2000);
						    } 
					   catch(InterruptedException e)
							{
								e.printStackTrace();
							}
					    }
			         }
               }
			public class ThreadJoinDemo 
            {
	           public static void main(String[] args) throws InterruptedException 
	            {
					JoinThread t=new JoinThread();
					t.start();
					t.join();//=======>(1)
					for(int i=0;i<=10;i++) 
					{
						System.out.println("TONY");
					}
				}

			}

           Note: If we comment line (1) then both main and child threads will be executed simultaneously and we ca't exact output.
                 If we are not commenting line (1) then main thread calls join() join method on child thread object hence main thread will wait until completing child thread in this output is NIHARIKA 10 times followed TONY 10 times


		 *case(ii) :-waiting of child thread until completing main thread
		   =========

		  	 class JoinThread extends Thread
             {
                 public MyThread mt;
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
					JoinThread t=new JoinThread();
				    JoinThread.mt=Thread.currentThread();
					t.start();
					for(int i=0;i<=10;i++) 
					{
						System.out.println("MAIN");
					}
				}

			}
		 *
		 *
		 *In the above Example child thread calls join method on main thread object hence child thread has to wait until completing main thread in this case out put is MAIN 10 times followed by CHILD 10 times
		 *
		 *case(iii):-
		 *==========
		 *             if main thread calls join method on child thread object and child thread join method on main thread object then both threads will wait forever and the program will be strucked ( this is something like dead lock).
		  EXample:-
		  =======
		     class JoinThread extends Thread
             {
                 public MyThread mt;
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
					JoinThread t=new JoinThread();
				    JoinThread.mt=Thread.currentThread();
					t.start();
					t.join();
					for(int i=0;i<=10;i++) 
					{
						System.out.println("MAIN");
					}
				}

			}  


		 *case(iv):-
		 *=========
		 *            if thread calls join method on the thread itself then the program will be structed this something like deadlock.
		 *            in this thread has to wait infinite amount of time;
		  Example:-
		  =========
		  public class ThreadJoinDemo 
            {
	           public static void main(String[] args) throws InterruptedException 
	            {
				  Thread.currentThread().join();
				}

			}  
		 *
		 *
		 *sleep():-     1). public static native void sleep() throws InturreputedException
		 *========      2). public static void sleep(long ms,int ns) throws InturreputedException

		 *            If a thread don't want to perform any operation for a particular amount of time then we should go for sleep() method. 
		 * 
		 *Every sleep() method throws inturreputedException hence ,which is checked Exception hence when ever we are using sleep() method compulsory we should handle interrupted exception either by try catch or by throws keyword otherwise  we will get CE:error
		 *
		 *
		 *
		 *
		 *                                                              <============================= sleeping state<=================================
		 *                                     						   ||																			  ||
		 *                                            if time expires (or) sleeping  thread got interrupted	                  Thread.sleep(1000); (or) Thread.sleep(1000,1000);
		 *                                     						   ||																			  ||
		 *                                                             ||                                                                             ||
		 *  MyThread t=new MyThread()=====>  {t.start()} =====>  Ready/Runnable ==================> {if T.S allocates processor} ================> Running =====> {if run() method completed}  ====>Dead     
		 *   (New/Born)  
		 *
	       Example:-
	       ========
	        public class ThreadSleepDemo 
            {
	           public static void main(String[] args) throws InterruptedException 
	            {
				  for(int i=0;i<=10;i++)
				  {
				   System.out.println("foo "+i);
				   Thread.sleep(1000);
				  }
				}

			}  


		 *How a Thread can interrupt another Thread:-  public void interrupt()
		 *============================================
		 *                                         A Thread can interrupt a sleeping thread or waiting thread by using interrupt() method of Thread class.
		 *                                         
		   Example:-
		   =========
			class ThreadInterrupted extends Thread
			{
				public void run() 
				{	
					try 
					{
						for(int i=0;i<=10;i++) 
						{
							System.out.println("Lazy Thread");
							Thread.sleep(1000);
						}
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
					t.interrupt();//====(1)
					System.out.println("main END");
				}
			}

		 *
		 *If we Comment line (1) then main  thread won't interrupt child thread in this case child thread will execute  10 times
		 *If we uncomment line (1) then main thread interrupts child thread in this case output is Main end ,Lazy Thread , i got interrupted
		 *
		 *
		 *
		 *
		 * * * Note: When ever we are calling interrupt method() if target thread not in sleep state or waiting state then there is no impact of interrupt call immediately, interrupt call will be waited until target thread entered into sleeping or waiting state.
		 *           If the target thread entered into sleeping or waiting state then immediately interrupt call will interrupt the target thread. 

                If the target thread never entered into sleeping or waiting state in its life time then there is no impact of interrupt call this is the only case where interrupt call will be wasted.

          Example:-
          ===========
            class ThreadInterrupted extends Thread
			{
				public void run() 
				{	
				       for(int i=0;i<=10000;i++) 
						{
							System.out.println("Lazy Thread "+i);
						}
					try 
					{
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
					t.interrupt();//====(1)
					System.out.println("main END");
				}
			}


             In above example interrupt call waited until child thread completes for loop 10000 times .


		 * * * Comparison of yield() join() and sleep()
		 *
		 *
		 * property                        yield()                                join()                          sleep()
		 *
		 *1). purpose             if a thread wants to pause its execution     If a thread wants to wait until    If a thread don't want to perform 
		 *                        to give chance remaining threads which       completing some other thread.      any operation for a particular amount of time.
		 *                        are having same priority.  
		 *
		 *2). is it overloaded?        NO												YES									YES
		 *
		 *3).  is it final?            NO												YES									NO
		 *
		 *4). is it throws IE?         NO												YES									YES
		 *
		 *5). is it native?            YES												No                                  sleep(long ms) is native
		 *																													sleep(long ms,int ns) non-native
		 *
		 *6) is it static?			   YES												NO									YES
		 *
		 *
		 *
		 *
		 *
		 *
		 *
		 *======================
		 * * * * Synchronization:-
		 *=======================
		 *                        Synchronize is the modifier  applicable  only for methods and blocks but not for classes and variables.
		 *                        If multiple threads are trying to operate simultaneously on the same java object then there may be a chance of data inconsistency problem to overcome this problem we should go for synchronize key word.
		 *                        If a method or block declared as synchronized then at  a time only one thread is allowed to execute that method or block on given object. so that data inconsistency problem will be resolved.
		 *                        
		 *  The main advantage of synchronize key word is we can resolve data inconsistency problems but the main disadvantage is it increases waiting time of threads and creates performance problems.
		 *  Hence if there is no specific requirement then it is not recommended to use synchronized key word;
		 *                        
		 * Internally synchronization concept is implemented by using lock. 
		 * Every object in java has a unique lock.
		 * When ever we are using synchronized then only lock concept will came into the picture.
		 * 
		 *I a thread wants to execute synchronized method on the given object first it has to get lock of that object, once thread got the lock then it is allowed to execute any synchronized method on that object. once method execution completes automatically thread releases lock.
		 *Acquiring and releasing lock internally takes care by JVM and Programmer not Responsible for this activity.
		 *
		 *
		 * * * While a thread executing synchronized method on the given object ,the remaining threads are not allowed to execute any synchronized method  simultaneously on the same object but remaining threads are allowed to execute non-synchronized methods simultaneously
		 *
		 *Example :-
		 *==========
		 *
		 *class Demo
		 *{
		 *  synchronized m1()
		 *  {
		 *      ------
		 *  }
		 *  synchronized m2()
		 *  {
		 *      ------
		 *  }
		 *  m3()
		 *  {
		 *      ------
		 *  }
		 *}
		 *
		 * * * Lock concept is implemented based on object but not based on method.
		 *                         In java every Object having two areas
		 *
		 *                       ======================================
		 * this area can be      ||                 |    		    	|| this area can be accessed
		 * can be accessed by    ||                 |  		 		    || by only one thread at a time
		 * any number of         || non-synchronized|	synchronized    ||
		 * threads simultaneously||   area          |    area 		    || 
		 *                       ||                 |   				||
		 *                       ||                 |   				||
		 *                       ======================================
		 *                                    Object
		 *
		    class Demo
		    {	     
		       synchronized area
		       {
		          where ever we are performing update operations (Insert,update,Delete)
		          i.e where state of object changing  
		       }
		       non-synchronized area
		       {
		          where ever object state won't be changed like Read operation(select)		        
		       }
		    }

		  Example:-
		  ========
		     class Reservation
		    {	     
		       <non-synchronized> checkAvalability
		       {
		          =========----======
		       }
		      synchronized bookTicket
		       {
		          =========---========
		       }
		    }     
Example:-
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
		Display d=new Display();
		DisplayThread t1=new DisplayThread(d,"TONY");
		DisplayThread t2=new DisplayThread(d,"NIHARIKA");
		t1.start();
		t2.start();

	}
}

		 * If we  are not Declaring wish method as synchronized then both threads will be executed simultaneously and hence we will get irregular output
		 *
		 * If we  are  Declare wish method as synchronized then at a time only one thread is allowed to execute wish method on the given Display object hence we will get regular output.
		 *
		 *Case Study:- 
		 *===========
		                    Display d1=new Display();
		                    Display d2=new Display();
							DisplayThread t1=new DisplayThread(d1,"TONY");
							DisplayThread t2=new DisplayThread(d2,"NIHARIKA");
							t1.start();
							t2.start();

		 *
		 *Even though wish method is synchronized  we will get irregular output B'z Threads are operating on Different Java Objects
		 *
		 *Conclusion: If multiple threads are operating on same java object then synchronization is required.
		 *            If multiple threads are operating on multiple java Objects then synchronization is not required.
		 *
		 *
		 *
		 * * *Class Level lock:-
		 * =====================
		 *                       Every class in java has a unique lock which is nothing but class level lock.
		 *                       If a thread wants to execute a static synchronized method then thread required class level lock.
		 *                       once thread got class level lock then it is allowed to execute any static synchronized method of that class.
		 *                       once method execution completes automatically thread releases lock.
		 *
		 *
		 *
		 *While a thread executing static synchronized method the remaining threads area not allowed to executed any static synchronized method of that class simultaneously but remaining threads are allowed to execute, the following methods simultaneously
		 * 
		 *1). static method1()       // Normal static method
		 *
		 *2). synchronized  method1()// Instance synchronized method
		 *
		 *3). method1()              // Normal Instance method
		 *
		 *
		 *
		 *Synchronized Block:-
		 *===================
		 *                    If very few lines of code required synchronization then it is not recommended to declare entire method as synchronized.
		 *                    We have to enclose those few lines of the code by using synchronized block.
		 *                    The main advantage of synchronized block over synchronized method it reduces waiting time of threads and improves performene of the system.
		 *
		 *
		 *We can declare synchronzed block as follows
		 *
		 *1) to get lock of currect Object     2) to get lock of perticular Object       3) to get class level lock
		 *
		 *   synchronized(this) 				synchronized(b)                       synchronized(Display.class)
		 *   {									{									  {
		 *    ---------                           -----------							--------
		 *    ---------							  -----------							--------
		 *    ---------							  -----------							--------
		 *   }									}									  }
		 *
		 * * * if a thread got lock of corresponding object(this,b,class) then only it is allowed to execute corresponding area.
		 *
		 Example:-
		 ==========
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
}
		
		
		 * * * Lock concept is applicable onliy for Objects types and classes types but not for primitives hence we can't pass primitive type as argument to synchrinized block otherwise we will get compile time erroe CE:unexcepeted type found: int required :refernce
		 *
		 *ex:-
		 *====
		 *int x=10;
		 *
		 * synchronized(x)
		 *  {
		 *
		 *
		 *  } 
		 *CE:unexpected tye found: int required: reference
		 *
		 *
		 * * * FAQs:-
		 * ===========
		 * 1). what is synchronized keyword where we can apply?
		 * 2). Explain advantage of sychronized keyword?
		 * 3). Explain disadvantage of synchrinized keyword?
		 * 4). What is race condition?
		 *     If multiple threads are oprating simulteneously on same javaobject then there may be achance of datainconsistency problem, this is called race condition.We can overcome this problem by using synchronized keyword.
		 * 5). What is object lock when it is required?
		 * 6). what is class level lock when it is required?
		 * 7). what is diff between class level lock object level lock?
		 * 8). while a thread executing synchronized method on the given object, is the reaminning allowed to execute any other synchronized method simultaneously on the same object? NO
		 * 9). what is synchronized block?
		 * 10). How to declare synchronized block to get lock of current object?
		 * 11). How to declare synchronized block to get Class level lock?
		 * 12). what is the advantage of synchronized block ober synchronized method?
		 * 13). is thread can  aquire multiple locks simultaneusly? YES ofcourse from different objects
		 *
		 *EX:-
		 *====
		  public class X
          {
			public synchronized void m1()
			{
				//here thread has lock of 'x' object
				 Y y=new Y();
				 synchronized(y)
				 {
				  // here thread has lock of 'x','y'
				   
				    Z z=new Z();
				 	synchronized(z)
				     {
				      // here thread has lock of 'x','y',z'
				 	
				     }
				 }
			 }
		  }
		 
		 
		 
		 *14). what is synchronized statement?
		 *  
		 * The statemsnt presents in synchronized method and synchronized block are called synchronized statements.
		 *
		 *
		 *
		 *
		 *Inter Thread Communication:-
		 *============================ 
		 *                            Two threds can communicate with each other by using wait(),notify(),notifyAll() methods.
		 *                            The Thread wich is expecting Updation is responsible to call wait() method then immediatly the thread will entered into waiting state.
		 *                            The Thread wich is responsible to perform updatation ,after performing updation it is responsible to call notify() method then waiting thread will get that notification and continuing its execution with those updated items.
		 *                            
		 * * * wait(), notify(),notifyAll() methods present in Object class but not in Thread class b'z Thread can call these methods on any java object.
		 * 
		 * * * To call wait(),notify(),notifyAll() methods on any object ,Thread should be owner of that object that is the Thread should has lock of that object that is the thread should in inside synchronized area.
		 *     Hence we can call wait(),notify(),notifyAll() methods only from synchronized area other wise we will get 'RuntimeException: IlligalMonitorStateException'
		 *
		 * * * If a Thread calls wait() method on any object it immediately releases lock of that perticular object and entered into waiting state.
		 *
		 * * * If a Thread calls notify() method on any object it releaases the lock of that object but may not immediately.
		 *
		 * * * Except  wait(), notify(), notifyAll() mthods there is no other method where thread releases lock.
		 * 
		 * 
		 * Which of the following are valid?
		 * 
		 * 1) if Thread calls wait() method immediately it will entered into waiting state without releasing any lock? Invalid
		 * 2) if threaad calls wait() method it realeses the lock of the that object but may not immediately? Invalid
		 * 3) if a thread calls wait() method on any object it releases all locks aquired by that thread and immediately entered into waiting state.? Invalid
		 * 4) if thread calls wait() metod on any object it immediately releases the lock that perticular object and entered into waiting state? Valid
		 * 5) if ahtread calls notify() method on any object it immediately the lock of that perticular object?Invalid
		 * 6) if a thread calls notify() method on any object it releares the lock that object but may not immediately? Valid
		 * 
		 * =====================================================
		 * (1) public final void wait() throws InterruptdExeption
		 * (2) public native final void wait(long ms) throws InterruptdExeption
		 * (3) public final void wait(long ms,int ns) throws InterruptdExeption
		 * 
		 * (1) public final native notify()
		 * (2) public final native notifyAll()
		 * 
		 *Note:-
		 *======
		 *        Every wait() method throws interuupted exception which is checked exception hence when ever we are using wait() method we should handle this inturrupted exception either by try catch or throws keyword other wise we will get CError
		 *        
		 *																					1).if waiting threa got notification
		 *																					2).if time expires
		 *																					3).if waiting threead got inturrepted.
	     *                                       {another waitin state(to get lock)}<==========================================================={waiting state}
		 *                                     						   ||																			  ||
		 *                                            if waiting thread got lock	                                         obj.wait(); (or) obj.wait(100); obj.wait(1000,1000);
		 *                                     						   ||																			  ||
		 *                                                             ||                                                                             ||
		 *  MyThread t=new MyThread()=====>  {t.start()} =====>  Ready/Runnable ==================> {if T.S allocates processor} ================> Running =====> {if run() method completed}  ====>Dead     
		 *   (New/Born)  
		 *
		 *Example:-
		 *=========
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

		 
		 
		 *
		 *Producer Consumer Problem:-
		 *===========================
		 *							 Producer Thread is responsible  to produce items to the queue and consumer thread is responsible to consume items from queue.
		 *							 If queue is empty then Consumer thread will call wait() method and entered into waiting state.
		 * 							 After producing items to queue producer threads is responsible to call notify() method then waiting consumer will get that notification and continue its execution with updated items.
		 * 
		
		 Class ProducerThread                                     class ConsumerThread
		 {									 					  {
		    produce()                                               consume()
		    {														{
		       synchronized(q)										  synchronized(q)
		       {														{
		         Produce items to queue									  if( q is empty)
		         q.notify();												  q.wait();
		       }														  else
		    }																  continue reading items
		 }																}
		 *															}
		 *														   }
		 *
		 *
		 *
		 *Difference betweeen notify() and notifyAll():-
		 *==============================================
		 *											     we can use notify() method to give notification to only one waiting thread , if multiple threads are waiting waiting then only one thread will be notify and the reaminig threads are to wait for further notification
		 *												 Which thread will notify() we can't expect it depends on JVM.
		 *                                               We can use notifyAll() method to give notification for all waiting threads of a perticular object ,Even though multiple threads notified but execution will be performed one by one b'z threads required lock and only one lock is avialabe
		 *
		 *
		 *
		 *Note: on which object we are calling wait() metgod thread the lock of that perticaular object for example if we are calling wait() method on s1() then we ahave to get lock of s1() object but not on s2() object
		 * Stach s1=new Stack();
		 * Stack s2=new Stack();
		 * Ex:-
		 * ===
		 *    synchronized(s1)                         synchronized(s1)
		 *    {											{
		 *     ----										-------
		 *      s2.wait();								s1.wait();
		 *     ----										------
		 *    }											}
		 *    CE:IlligalMonitorStateException
		 *
		 *
		 *==========
		 *DeadLock:-
		 *==========
		 *          if two threads are waiting foreach other forever such type of inifinite waiting is called DeadLock.
		 *           
		 *
		 * * * Synchronized keyword is the only reason for dead lock situation hence while using synchronized we have to take special care.
		 *     There are no resolve techinics in dead lock but several prevention tachnics are available.
		 *
		 *
		 *
		 *Example:-
		 *========
		
		
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
		 *
		 *
		 *In the above program if we remove atleast one synchronized keyword then the program won't enetered into deadlock hence synchronized keyword is the only reason to entered into dead lock situation.
		 *Due to this while using synchronized key word we have to take special care.
		 *
		 *
		 *
		 *Deack lock Vs starvation:-
		 *=========================
		 *							Long waiting of athread where waiting never ends is called dead lock
		 *                          where as long waiting of thread where waiting ends at certain point is called starvation.for example low priority threads has to wait untill completing all high priority threads it may be long waiting but ends at certain point is which is nothing but stavation.
		 *
		 *
		 *
		 *DemanThread:-
		 *===============
		 *  			 The Threads which are executing in the back ground is called Deman Threads Best Examples are Garbage Collector,signal dispatcher etc.
		 *               
		 *  The main objective of deman threads is to provide support for non-deman threads (Main Thread). For example if main thread runs with low memory then JVM runs GC to destroy useless objects so that no. of bytes of free memory will be improverd, With this free memory   main thread can continue its execution.        
		 *  Useually deman threads having low priority but based on our requirement can with high priority also.
		 *  We can check deman nature of thread by using isDeman() method of Thread class.
		 *  public boolen isDeman()
		 *  We can change deman nature of thread by using setDeman()
		 *  public void setDeman(boolen b)
		 *  But changing Deman Nature is possible before starting of a thread only. After starting a thread if we trying to change deman nature we will get RE:illegal thread state exception.
		 * 
		 *  
		 *  Default Nature of Thread:-
		 *  ==========================
		 *		By Default Main thread is always non-deman and for all remaining threads deman nature will be inherited	from parent to child that is if the parent thread is deman then automaticallly child thread is also deman.
		 *      And if the parend thread is non-deman then child thread also non-deman.					
		 *
		 *
		 * * * Note: it is impossible to change deman nature of main thread B'z it is already started by JVM at begining.
		 * 
		 * Example:-
		 * =-=======
		 * 
class TestThread extends Thread
{
	
}

public class Sample 
{
	public static void main(String[] args) 
	{	
		System.out.println("main thread  is deman "+Thread.currentThread().isDaemon());
		//Thread.currentThread().setDaemon(true);//output:Exception in thread "main" java.lang.IllegalThreadStateException
		TestThread t=new TestThread();
		System.out.println(t.isDaemon());
		t.setDaemon(true);
		System.out.println("child is deman  "+t.isDaemon());
		t.start();
		
	}
}

		 *
		 * When ever last non-Deman thread is terminates  automatically all deman threads will be terminated. irrespective of their position
		 * 
		 *

class TestThread extends Thread
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("Child Thread");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Sample 
{
	public static void main(String[] args) 
	{		
		TestThread t=new TestThread();
		t.setDaemon(true);//-----(1)
		t.start();
		System.out.println("End of Main");		
	}
}

		 *
		 *
		 * If we are commeting line (1) both main and child threads are non-deman and hence both threads will be executed untill their completion
		 * If we are not commeting line (1) then main thread is non-deman and child thread is deman  hence when ever main thread terminates automatically child thread will be terminated. in this case output is 
		 *
		 *
		 *
		 *
		 *Java Multithreading concept is implemented by using following two models:- 1) Green Thread Model 2) Native OS Model
		 *1). Green Thread Model:-
		 *======================== The thread which is managed completely by JVM without taking underlying  Os Support is  called Green Thread.
		 *Very few OS's like SUN Solaries provide support forGreen Thread model.
		 *Any way Green Thread model is deprecated not Recomended to use.
		 *2) Native Os Model:-
		 *==================== The thread which is managed by JVM with the help of underlying  OS is called Native OS Model.
		 *All windows based OS's provided support for Native OS Model.
		 *
		 *How to stop a thread :-
		 *=======================
		 * we can stop a thread execution by using stop() method of thread class  public void stop()
		 * if we call stop method then the thread will entered into dead state ,any way stop method is deprecated and not recomended to use.
		 * 
		 * How to suspend and Resume of a thread:-
		 * ======================================= we can suspend  athread by using suspend() of Thread class then immediatly that thread will be entered into usspended state
		 * We can resume a suspended thread by using resume() method of thread  class then suspended thread can continue its execution.
		 * public void suspend()
		 * public void resume()
		 * Any way these methods are deprecated and not recomended to use.
		 * 
		 * 
		 * 
		 *
		 *Thread Group:-
		 *============== 
		 *			   Based functionality we can group threads into a single unit which is nothig but thread group; i.e thread group contains a group of threads
		 *In addition to threads Thred group can also contain sub-thread groups.
		 *the main advantage of maintaing threads in the form of thread group is  we can perform common operations  very easly.
		 *
		 * * *Every Thread in java belongs to  some group 
		 * * *Main Thread belongs to Main group
		 * * *Every Thread group in java is the child group of system group either directly or indirectly hence system group acts as root for All Thread groups in java.	 
		 *
		 *System group contains several system level Threads like 
		 * 1) finalizer,2) Reference handler,3)Atttach listioner
		 * 
		 *ThreadGroup is a java class present in java.lang package and it is direct child class of Object Class.
		 *
		 *Constructors:-
		 *==============
		 *(1).ThreadGroup g=new ThreadGroup(String groupName);
		 *     Creates a new ThreadGroup with the specifed group name.
		 *     The parent of this new group is Threadgroup of currently executing thread.
		 *Ex:-  ThreadGroup g=new ThreadGroup("FirstGoup);
		 *
		 *(2).ThreadGroup g=new ThreadGroup(ThreadGroup name,String groupname);
		 *    Creates a new thread group with the specified group name
		 *    The parent of this new thread group is specified parent group.
		 *    ThreadGroup g1=new ThreadGroup(g,"SecondGroup");
public class Sample 
{
	public static void main(String[] args) 
	{		
		ThreadGroup g=new ThreadGroup("FirstGroup");
		System.out.println(g.getParent().getName());
		ThreadGroup g2=new ThreadGroup(g,"SecondGroup");
		System.out.println(g2.getParent().getName());
	}
}  

		 *
		 *Important methods of ThreadGroup
		 *
		 *1)String getName()
		 *2)int getMaxPriority()
		 *3)void setMaxPriority(int p)//default max priority is 10
		 * Threads in threadGroup that  already have higher priority won't be effected But for newly addedd threads this max priority is appicable.
		 *4) ThredGroup getParent()
		 *5) void list()
		 *6) int activeCount()
		 *7) int activeGroupCount()
		 *8) int enumerate(Thread[] t)
		 *9) int enumerate(ThreadGroup[] t)
		 *10) boolen isDaeman()
		 *11) void setDaeman(boolean b)
		 *12) void interrupt()
		 *13) void destroy()
		 *
		 *
		 *
		 *java.util.concurrent:-
		 *======================
		 *                       
		 *The Problems with tradional synchronized keyword:-
		 *
		 *1). we are not having any flexibility to try for a lock with out waiting.
		 *2). there is no way to specify maximam waiting time for a thread to get lock so that thread will wait untill gettting the lock which may creates performence problems which may cause dead lock.
		 *3). if a thread releases lock then which waiting thread will get that lock we are not having any control on this.
		 *4). there is no API to list out all waiting threads for a lock.
		 *5). a synchronized compusalry we should use either at method level or with in the emthod and it is not possible to use across muliple methods. 
		 *
		 *  To overcome these problems SUN people introduced java.util.concurrent.locks package in 1.5 Version ,it also provides several enhancements to the programmer to provode more control on concurrency.
		 *  
		 *
		 *Lock(I):-
		 *=========
		 *          Lock Object is similar to implisit lock acquired by a thread to execute synchronized method or synchronized block.
		 *          Lock implementations provide more extensive oprations than traditional implisit locks.
		 *
		 *Important Methods of Lock(I):-
		 *=============================
		 *1) void lock():- we can use this method  to aquired a lock, if lock is already avialable  then immediately current thread will get that lock, if the lock is not already avialable  then it will wait until getting the lcok ,it is exctaly same behaver of traditional  synchronized key word.
		 *2) boolen trylock():- To aquire lock without waiting, if the lock is available then the thread aquire the lock and returns true if lock is not available then this returns false and can continue its execution without waiting in this case thread never be entered into waiting state.
		 *if(l.tryLock())
		 *{
		 * perform safe operations
		 *}
		 * else
		 * {
		 *  perform alternative operations
		 * }   						
		 *
		 *3) boolean tryLock(long time,TimeUnit unit):- if lock is available then the thread will get the lock and continue its execution if the lock is not available then the thread will wait untill specified amount time still if the lock is not available then thread can continue its execution. 
		 *
		 * TimeUnit: it is an enum present in java.util.concurrent package (NANOSECONDS,MICROSECONDS,MILLISECONDS,DAYS,SECONDS,MINUTES,HOURS} 
		 * 
		 *if(l.tryLock(1000,TimeUnit.SECONDS))
		 *{
		 * perform safe operations
		 *}
		 * else
		 * {
		 *  perform alternative operations
		 * }   						
		 *
		 * 4)void lockinterrubly(): acquires the lock if it is available and retuns immediately,if the lock is not avaible then it will wait,while waiting if the thread is interrupted then thread won't get the lock.
		 * 5)void unlock(): to releases lock ,to call this method compusalry current thread should be ower of the lock other wise we will get RE:illigalmonitarstateException
		 * 
		 *
		 *
		 *
		 */


	}
}
