package com.app.numbers;

public class ArmStrongNumber {
	public static void main(String[] args) {
		int n1=100,n2=1000,sum=0;
		for(int i=n1;i<=n2;i++)
		{
			int temp=i;
			while(temp>0)
			{
				int r=temp%10;
				sum=sum+r*r*r;
				temp=temp/10;
			}
			if(sum==i)
				System.out.print(i+" ");
			sum=0;
		}
	}
}
