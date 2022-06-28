package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {

	private static final String HOST = "localhost";
	private static final int PORT  = 3306;
	private static final String SCHEMA = "projects";
	private static final String USER = "projects";
	private static final String PASSWORD = "projects";
	
	public static Connection getConnection() {
		String uri = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", HOST, PORT, SCHEMA);
		
		try {
			Connection connString = DriverManager.getConnection(uri, USER, PASSWORD);
			System.out.println("Connection to " + uri + " succesful!");
			return connString;
		} 
		catch (SQLException e) {
			throw new DbException(e);
		}
	}
}
