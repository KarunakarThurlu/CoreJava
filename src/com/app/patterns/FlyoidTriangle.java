package com.app.patterns;

public class FlyoidTriangle {
	public static void main(String[] args) {
		/*int c=1;
		for(int i=1;i<=7;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(c+"  ");
				c++;
			}
			System.out.println();
			
			output: 1
			        12
			        123
			        1234
			        12345
		}*/
	
		/*
		 * for(int i=1;i<=7;i++) {
		 *   for(int k=7;k>=i;k--) {
		 *        System.out.print(" ");
		 *   }
		 *   for(int j=1;j<=i;j++) { 
		 *         System.out.print(j); 
		 *   } 
		 *   System.out.println(); 
		 *  }
		 *
		 *
 output:-
		   *
		  **
		 ***
		****
	   *****
	*/
		
		/*for(int i=1;i<=7;i++)
		{
			for(int k=7;k>=i;k--)
			{
				System.out.print(" ");
			}
			//System.out.println();
			for(int j=1;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println();

		}
output:-
*******
 ******
  *****
   ****
    ***
     **
      *
       */

	   int[] array = new int[6];
	   for (int i = 0; i < array.length; i++) {
		   for (int j = array.length;j>=0; j--) {
			   System.out.print(" ");
		   }
		   for (int j = 0; j <= i; j++) {
			System.out.print("* ");
		   }
		   System.out.println();
	   }
	}
}
