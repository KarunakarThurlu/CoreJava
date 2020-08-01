package com.app.arrays;

public class CommenElementsIn3Arrays 
{
	public static void main(String[] args)
	{
      int a1[]= {10,20,30,40,50};
      int a2[]= {60,70,80,90,20,50,30,40};
      int a3[]= {70,40,50,67,9,20};
      for(int i=0;i<a1.length;i++)
      {
    	  for(int j=0;j<a2.length;j++)
    	  {
    		  for(int k=0;k<a3.length;k++) 
    		  {
    		  if(a1[i]==a2[j] && a2[j]==a3[k])
    			  System.out.println(a3[k]);
    		  }
    	  }
      }
	}
}
