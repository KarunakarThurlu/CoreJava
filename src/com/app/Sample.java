package com.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class Sample 
{
	public static void main(String[] args) throws ClassNotFoundException 
	{
		Class.forName("org.postgresql.Driver");
		try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres",
				"postgres")) {
			if (con != null) {
				System.out.println("DB connected");
			System.out.println(Sample.class.getModule());
			}
			else
				System.out.println("DB not connected");
			if(con !=null)
				System.out.println(con.getSchema());
		} catch (Exception e) {
			System.err.println(e);
			
				
		}
		
		
	}
}

/*case(1):
 *   input   str1="the"
 *           str2="another
 *           
 *   output:  anor
 *   
 * 
 * 
 * case(2):
 *   input  str1="ae"
 *          str2="apple";
 *          
 *  output: -1 
 */























/*

Input : {[]{()}}
Output : Balanced
Input : [{}{}(]
Output : Unbalanced
Input : [)(]
Output : Unbalanced
 * 
 */
