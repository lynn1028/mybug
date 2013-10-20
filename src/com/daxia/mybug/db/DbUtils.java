package com.daxia.mybug.db;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

	
public class DbUtils {
	private static BasicDataSource ds=null;
	
	//在类中最先执行并且只执行一次,专门为静态变量初始化
	static {
		/*
		System.out.println("已经执行此代码块");
		// TODO KEVIN 初始化连接
		//驱动程序名称
		String driver="com.mysql.jdbc.Driver";
		//指向要访问的数据库名
		String url="jdbc:mysql://127.0.0.1:3306/bugdb?useUnicode=true&characterEncoding=utf8";
		//数据库用户名
		String user="root";
		//数据库密码
		String password="1028";
		try
		{
			//加载驱动程序
			Class.forName(driver);
			//连接数据库
		    conn=DriverManager.getConnection(url,user,password);
		    System.out.println("ssssssssssssssss.....");
		}catch (Exception ex) {
			// TODO: handle exception
			conn=null;
			ex.printStackTrace();
		}*/
		ds=new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/bugdb?useUnicode=true&characterEncoding=utf8");
		ds.setUsername("root");
		ds.setPassword("1028");
		ds.setMaxActive(20); //数据库最大活动连接数
		ds.setMinIdle(2); //至少保持两条的连接
	}
	
	//获得数据连接
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	//关闭连接
	public static void closeConnection(Connection connection) throws SQLException{
		if(connection!=null){
			connection.close();
		}
	}
	
	
	/**
	 * 开始事务
	 * @param connection
	 */
	public static void beginTransaction(Connection connection) throws SQLException{
		connection.setAutoCommit(false); //设定连接不自动提交
	}
	
	/**
	 * 提交事务
	 * @param connection
	 * */
	public static void commitTransaction(Connection connection) throws SQLException{
		connection.commit(); //提交
	}
	
	/**
	 * 回滚事务
	 * @param connection
	 */
	public static void rollbackTransaction(Connection connection) throws SQLException{
		connection.rollback();
	}
}
