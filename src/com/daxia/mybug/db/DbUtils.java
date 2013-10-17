package com.daxia.mybug.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DbUtils {

	private static BasicDataSource ds = null; 
	
	static {
		ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/mybug??useUnicode=true&characterEncoding=utf8");
		ds.setUsername("root");
		ds.setPassword("sa");
		ds.setMaxActive(20);
		ds.setMinIdle(2);
		// test for it
		// 哈哈哈哈
	}
	   
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public static void closeConnection(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}
	
	/**
	 * 开始事务
	 * @param connection
	 * @throws SQLException 
	 */
	public static void beginTransaction(Connection connection) throws SQLException {
		connection.setAutoCommit(false);
	}
	
	public static void commitTransaction(Connection connection) throws SQLException {
		connection.commit();
	}
	
	/**
	 * 回滚事务
	 * @param connection
	 * @throws SQLException 
	 */
	public static void rollbackTransaction(Connection connection) throws SQLException {
		connection.rollback();
	}

	public static void main(String[] args) throws SQLException {
	    System.out.println(getConnection());
    }
	
}
