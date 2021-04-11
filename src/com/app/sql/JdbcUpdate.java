package com.app.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdate {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/testdb";
			String userName="postgres";
			String password="postgres";
			Connection connection=DriverManager.getConnection(url,userName,password);	
			Statement stmt=connection.createStatement();
			String Query="UPDATE countrys SET c_population=52380400 where c_id=4";
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
