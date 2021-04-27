package com.app.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdate {
	static String  url="jdbc:postgresql://localhost:5432/testdb";
	static String userName="postgres";
	static String password="postgres";
	public static void main(String[] args) {
		try {
			//Step 1: Loading Driver
			Class.forName("org.postgresql.Driver");

			//Step 2: Getting Connection Object
			Connection connection=DriverManager.getConnection(url,userName,password);	

			//Step 3: Getting Statement from Connection Object
			Statement stmt=connection.createStatement();
			String Query="UPDATE countrys SET c_population=52380400 where c_id=4";

			//Step 4: Executing Query Using Statement.
			int result= stmt.executeUpdate(Query);
			if(result==1)
				System.out.println("Updated Successfully!");
			else
				System.out.println("Not Updated");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
