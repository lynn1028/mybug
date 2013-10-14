package com.daxia.mybug.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.daxia.mybug.db.DbUtils;
import com.daxia.mybug.exception.MyException;
import com.daxia.mybug.model.User;

public class UserDAO {
	
	public User findByUsernameAndPassword(String username, String password) {
		Connection conn = null; 
		try {
			conn = DbUtils.getConnection();
			String sql = "select id, username, password from user where username = ? and password = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
        } catch (SQLException e) {
        	throw new MyException("查询用户发生异常", e);
        } finally {
        	try {
	            DbUtils.closeConnection(conn);
            } catch (SQLException e) {
	            e.printStackTrace();
            }
        }
		
		return null;
	}

	public void add(User user) {
		Connection conn = null; 
		try {
			conn = DbUtils.getConnection();
			String sql = "insert into user(username, password) values(?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.executeUpdate();
        } catch (SQLException e) {
        	throw new MyException("查询用户发生异常", e);
        } finally {
        	try {
	            DbUtils.closeConnection(conn);
            } catch (SQLException e) {
	            e.printStackTrace();
            }
        }
    }
}
