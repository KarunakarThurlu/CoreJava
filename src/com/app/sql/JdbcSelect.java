package com.app.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelect {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		String url="jdbc:postgresql://localhost:5432/testdb";
		String userName="postgres";
		String password="postgres";
		String QUERY="Select * from user_table where user_id =?;";
		Connection connection=null;
		try {		  
			connection = DriverManager.getConnection(url,userName,password);		             
			PreparedStatement psmt = connection.prepareStatement(QUERY);
			psmt.setInt(1, 3);
			ResultSet resultSet = psmt.executeQuery();
			while(resultSet.next()) {
				System.out.println("Country Name : "+resultSet.getString("user_name") +"\t  Courrency : "+resultSet.getString("user_email")+"\t\t  Capital : "+resultSet.getString("user_gender"));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
