package com.app.java5Features;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FeatureEx {
	/*
	 * 1). Future<V> was introduced in jdk1.5
	 * 2). Future<V> is required When we are working with Asynchronous Tasks by using Callable<T>
	 * 3). Callable<T> is Functional interface, it contains call() abstract method.
	 * 4). We can call Callable<V> interface call() method by using java.util.concurrent.ExecutorService;
	 * * * * If our Requirement Asynchronous task return something then go for Callable<T>. 
	 * * * * If our Requirement Asynchronous task return nothing then go for Runnable. 
	 * 
	 * 
	 */
	public static void main(String[] args) throws InterruptedException,Exception {
		
		ExecutorService executerService=Executors.newFixedThreadPool(5);
		
		Callable<String> task1=new Callable<String>(){
			public String call() throws Exception {
				System.out.println("Callable!...."+Thread.currentThread().getName());
				Thread.sleep(5000);
				return "First Task is completed";
			}
		};
		Future<String> f= executerService.submit(task1);
		
		System.out.println(f.get(3,TimeUnit.SECONDS));
		executerService.shutdown();
	}
}
//Example1:-
/*
public class FeatureEx {
	public static void main(String[] args) throws InterruptedException,Exception {
		ExecutorService executerService=Executors.newSingleThreadExecutor();
		Callable<String> c=new Callable<String>(){
			public String call() throws Exception {
				System.out.println("Callable!...."+Thread.currentThread().getName());
				Thread.sleep(5000);
				return "Hello From Callable";
			}
		};
		Future<String> foo=executerService.submit(c);
		//case(i)
    	System.out.println(foo.get()+Thread.currentThread().getName());
		//case(ii)
		System.out.println(f.get(3,TimeUnit.SECONDS));
		executerService.shutdown();
	}
}
*/

//Example2:-
// It will wait until all tasks are completed.

/*
 public class FeatureEx {
	public static void main(String[] args) throws InterruptedException,Exception {
		
		ExecutorService executerService=Executors.newFixedThreadPool(5);
		
		Callable<String> task1=new Callable<String>(){
			public String call() throws Exception {
				System.out.println("Callable!...."+Thread.currentThread().getName());
				Thread.sleep(5000);
				return "First Task is completed";
			}
		};
		
		Callable<String> task2=new Callable<String>(){
			public String call() throws Exception {
				System.out.println("Callable!...."+Thread.currentThread().getName());
				Thread.sleep(3000);
				return "Second Task is completed";
			}
		};
		
		Callable<String> task3=new Callable<String>(){
			public String call() throws Exception {
				System.out.println("Callable!...."+Thread.currentThread().getName());
				Thread.sleep(2000);
				return "Third Task is completed";
			}
		};
		
		List<Callable<String>> listOfTasks =List.of(task1,task2,task3);
		
		List<Future<String>> foo=executerService.invokeAll(listOfTasks);
    	
		foo.stream().forEach(s->{
			try {
				System.out.println(s.get()+" "+Thread.currentThread().getName());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
		
		executerService.shutdown();
	}
}*/

//Example3:-
// Returns the result of the fastest callable. (task3 in this case)

/*
public class FeatureEx {
public static void main(String[] args) throws InterruptedException,Exception {
	
	ExecutorService executerService=Executors.newFixedThreadPool(5);
	
	Callable<String> task1=new Callable<String>(){
		public String call() throws Exception {
			System.out.println("Callable!...."+Thread.currentThread().getName());
			Thread.sleep(5000);
			return "First Task is completed";
		}
	};
	
	Callable<String> task2=new Callable<String>(){
		public String call() throws Exception {
			System.out.println("Callable!...."+Thread.currentThread().getName());
			Thread.sleep(3000);
			return "Second Task is completed";
		}
	};
	
	Callable<String> task3=new Callable<String>(){
		public String call() throws Exception {
			System.out.println("Callable!...."+Thread.currentThread().getName());
			Thread.sleep(2000);
			return "Third Task is completed";
		}
	};
	
	List<Callable<String>> listOfTasks =List.of(task1,task2,task3);
	
   //===============================================
  // Returns the result of the fastest callable. (task3 in this case)
	String foo=executerService.invokeAny(listOfTasks);
	System.out.println(foo);
   //===============================================
	
	
	executerService.shutdown();
}
}
*/