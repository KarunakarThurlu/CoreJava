package com.app.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;

public class JdbcInsert {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/testdb";
			String userName="postgres";
			String password="postgres";
			Connection connection=DriverManager.getConnection(url,userName,password);	
			Statement stmt=connection.createStatement();
		    stmt.executeUpdate("INSERT INTO countries (c_name,c_population,c_capital,c_currency) VALUES('USA',32794000,'WD','USD')");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLTimeoutException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
