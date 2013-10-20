package com.daxia.mybug.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.daxia.mybug.dao.IUserDAO;
import com.daxia.mybug.db.DbUtils;
import com.daxia.mybug.model.User;

public class UserDAO implements IUserDAO
{
	//用户名密码验证
	public User findByUsernameAndPassword(String userName,String password)
	{
		Connection conn=null;
		try
		{
			conn=DbUtils.getConnection();
			String sql="SELECT * FROM user WHERE username=? and password=?";
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1,userName);
			statement.setString(2,password);
			ResultSet rs=statement.executeQuery();
			if(rs.next())
			{
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}finally
		{
			try{
				DbUtils.closeConnection(conn);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return null;
	}
	
	//添加用户
	public boolean add(User user){
		Connection conn=null;
		try
		{
			conn=DbUtils.getConnection();
			String sql="INSERT INTO user(username,password) VALUES(?,?)";
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			
			int result= statement.executeUpdate();
			if(result>0){
				return true;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally
		{
			try{
				DbUtils.closeConnection(conn);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return false;
	}
}
