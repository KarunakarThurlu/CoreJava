package com.app.java8Features;

import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ConsumerDemo implements Consumer<Integer> {

	@Override
	public void accept(Integer input) {
		System.out.println(input);	
	}
	public static void main(String[] args) {
		
		//=======Normal Approach=======
		
		Consumer<Integer> consumer=new ConsumerDemo();
		consumer.accept(20);
		
		//=======Using Lambdas=========
		
		Consumer<Integer> consumer1=a->System.out.println(a);
		consumer1.accept(30);
		
		Consumer<Integer> consumer2=(s)->{
			if(IntStream.range(2,s).noneMatch(x->s%x==0))
				System.out.println(s +" is Prime");
			else
				System.out.println(s +" is not Prime");
			};
		consumer2.accept(7);		 
				 
	}
}
