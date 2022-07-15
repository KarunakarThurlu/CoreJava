package com.app.numbers;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeRange {
	public static void main(String[] args) {

		int n1=1,n2=100,c=0;
		for(int i=n1;i<=n2;i++)
		{
			c=0;
			for(int j=2;j<=i/2;j++)
			{
				if(i%j==0)
				{
					c++;

				}
			}
			if(c==0)
			{
				System.out.print(i+" ");

			}
		}
		System.out.println();
		System.out.println("============");
		
		//2nd way
		IntStream.range(1,10)
		         .filter(number->IntStream.range(2,number).noneMatch(x->number%x==0))
		         .boxed()
		         .collect(Collectors.toList())
		         .forEach(x->System.out.print(x+" "));
		
		int count=0;
        for(int i=2;i<=10;i++){
        	int k=i;
            if(IntStream.range(2,k).noneMatch(x->k%x==0)){
                 count++;
            }    
        }
        System.out.println(count);
	}

}
