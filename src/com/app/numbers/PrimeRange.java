package com.app.numbers;

public class PrimeRange {
	public static void main(String[] args) {

		int n1=1,n2=100,c=0;
		for(int i=n1;i<=n2;i++)
		{
			c=0;
			for(int j=2;j<i;j++)
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

	}

}
