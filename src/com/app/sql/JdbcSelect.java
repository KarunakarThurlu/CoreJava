package com.app.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelect {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		String url="jdbc:postgresql://localhost:5432/testdb";
		String userName="postgres";
		String password="postgres";
		Connection connection=null;
		try {		  
			ResultSet resultSet = DriverManager
					             .getConnection(url,userName,password)
					             .createStatement()
					             .executeQuery("Select * from countrys")
					             ;
			while(resultSet.next()) {
				System.out.println("Country Name : "+resultSet.getString("c_name") +"\t  Courrency : "+resultSet.getString("c_currency")+"\t\t  Capital : "+resultSet.getString("c_capital"));
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
