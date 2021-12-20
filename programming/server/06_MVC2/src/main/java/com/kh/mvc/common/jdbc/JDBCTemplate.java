package com.kh.mvc.common.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	public static Connection getConnection() {
		Connection connection = null;
//		Properties properties = new Properties();
//		String filePath = JDBCTemplate.class.getResource("./driver.properties").getPath();
		
//		System.out.println(filePath);
		
		
		
		try {
//			properties.load(new FileReader(filePath));
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "WEB", "WEB");

			
			connection.setAutoCommit(false); //auto commit이 중단됨(잘못된거 입력시 커밋되면 롤백이 안되니까)


		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return connection;
	}
	
	public static void commit(Connection connection) {
		try {
			if(connection != null && !connection.isClosed())
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection connection) {
		try {
			if(connection != null && !connection.isClosed())
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection connection) {
		try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement statement) {
		try {
			if(statement != null && !statement.isClosed()) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet resultSet) {
		try {
			if(resultSet != null && !resultSet.isClosed()) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
