package com.app.designpatterns;

public class FactoryDesignPatternExample {
	public static void main(String[] args) {
		DBConnection connection=FactoryPattern.getConnection("Oracle");
		String connectionName=connection.getDataBaseConnection();
	    System.out.println(connectionName);	
	}
}

interface DBConnection{
	String getDataBaseConnection();
}


class PosrgreSQL implements DBConnection{
	@Override
	public String getDataBaseConnection() {
		return "PostgresSQL DataBase Connection";
	}
}


class MySQL implements DBConnection{
	@Override
	public String getDataBaseConnection() {
		return "MySQL DataBase Connection";
	}
}

class Oracle implements DBConnection{
	@Override
	public String getDataBaseConnection() {
		return "Oracle DataBase Connection";
	}
}

class FactoryPattern{ 
	
	public static DBConnection connection=null;
	
	public static DBConnection getConnection(String name) {
		
		switch (name) {
		
		case "Postgres":
			connection=	new PosrgreSQL();
			break;
		case "MySQL":
			connection=	new MySQL();
			break;
		case "Oracle":
			connection=	new Oracle();
			break;
		default:
			break;
			
		}
		
		return connection;
	}
}