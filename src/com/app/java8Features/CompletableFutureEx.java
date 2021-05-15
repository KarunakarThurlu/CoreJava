package com.app.java8Features;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureEx {

	/*@Karunakar.T
	 * ========================================================================
	 * * * CompletableFuture is used for asynchronous programming in Java * * *
	 * ========================================================================
	 *1).CompletableFeature<T> is extension to Future<V>
	 *2).Future has following drawbacks, To over come these drawbacks CompletableFeature<T> was introduced
	 *   (i).  No Exception Handling
	 *   (ii). You can not combine multiple Futures together
	 *   (iii).Multiple Futures cannot be chained together
	 *   (iv). You cannot perform further action on a Future’s result without blocking
	 *3).Transforming and acting on a CompletableFuture, Once got the result from asynchronous task then we can chain by using following methods.
	 *   (i).  thenApply()
	 *   (ii). thenAccept() 
	 *   (iii).thenRun()
	 * 
	 */

	public static void main(String... k) {
		CompletableFuture<String> greetingFuture=CompletableFuture.supplyAsync(()->{
			System.out.println("Enter into asynchronous task. "+Thread.currentThread().getName());
			try {
				//Do some logic here
				TimeUnit.SECONDS.sleep(4);
				return "Karun";
			} catch (InterruptedException e) {
				e.printStackTrace();
				return e.getMessage();
			}
		}).thenApply(name->{
			return "Hai.... "+name;
		}).thenApply(greeting->{
			return greeting+" How are you?";
		});
		
		try {
			String foo = greetingFuture.get();
			System.out.println(foo);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
//Example1:-
/*
 public static void main(String... k) {
		CompletableFuture<String> completableFuture=new CompletableFuture<String>();
		completableFuture.complete("Future Response");
		try {
			TimeUnit.SECONDS.sleep(4);
			System.out.println(completableFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
 }
*/

//Example2:-If we want to run some background task asynchronously and don’t want to return anything from the task, then you can use CompletableFuture.runAsync()

/*
 public static void main(String... k) {
		CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(()->{
			System.out.println("Enter into asynchronous task. "+Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(4);
				System.out.println("Running asynchronously... "+Thread.currentThread().getName());
				System.out.println("Exit of asynchronous task. "+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		try {
			completableFuture.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
 }
 */

//Example3:-If we want to run some background task asynchronously and return something from the task, then you can use CompletableFuture.supplyAsync()

/*
public static void main(String... k) {
		CompletableFuture<String> completableFuture=CompletableFuture.supplyAsync(()->{
			System.out.println("Enter into asynchronous task. "+Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(4);
				return "Hello from asynchronous task.";
			} catch (InterruptedException e) {
				e.printStackTrace();
				return e.getMessage();
			}
		});
		try {
		  String foo = completableFuture.get();
		  System.out.println(foo);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
	}
}
*/


/*
 * 1).All the methods in the CompletableFuture API has two variants - One which accepts an Executor as an argument and one which doesn’t -
 * 2).Variations of runAsync() and supplyAsync() methods
 *      static CompletableFuture<Void>  runAsync(Runnable runnable)
 *      static CompletableFuture<Void>  runAsync(Runnable runnable, Executor executor)
 *      static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)
 *      static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor)
 * 3).Here’s how you can create a thread pool and pass it to one of these methods -     
 *   
 *   Executor executor = Executors.newFixedThreadPool(10);
     CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
         try {
             TimeUnit.SECONDS.sleep(1);
         } catch (InterruptedException e) {
             throw new IllegalStateException(e);
         }
         return "Result of the asynchronous computation";
     }, executor);
 *
 *
 */

//Example4:-
/* We can use thenApply() method to process and transform the result of a CompletableFuture when it arrives. 
 * It takes a Function<T,R> as an argument. 
 * Function<T,R> is a simple functional interface representing a function that accepts an argument of type T and produces a result of type R -

public static void main(String... k) {
		CompletableFuture<String> greetingFuture=CompletableFuture.supplyAsync(()->{
			System.out.println("Enter into asynchronous task. "+Thread.currentThread().getName());
			try {
				//Do some logic here
				TimeUnit.SECONDS.sleep(4);
				return "Karun";
			} catch (InterruptedException e) {
				e.printStackTrace();
				return e.getMessage();
			}
		}).thenApply(name->{
			return "Hai.... "+name;
		}).thenApply(greeting->{
			return greeting+" How are you?";
		});
		
		try {
			String foo = greetingFuture.get();
			System.out.println(foo);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

 */
