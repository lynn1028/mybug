package com.daxia.mybug.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.daxia.mybug.db.DbUtils;
import com.daxia.mybug.exception.MyException;
import com.daxia.mybug.model.Bug;

public class BugDAO {
	
	public void add(Bug bug) {
		Connection conn = null; 
		try {
			conn = DbUtils.getConnection();
			String sql = "insert into bug(title, content, status, priority, userId) values(?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, bug.getTitle());
			statement.setString(2, bug.getContent());
			statement.setInt(3, bug.getStatus());
			statement.setInt(4, bug.getPriority());
			statement.setLong(5, bug.getUserId());
			statement.executeUpdate();
        } catch (SQLException e) {
        	throw new MyException("增加bug发生异常", e);
        } finally {
        	try {
	            DbUtils.closeConnection(conn);
            } catch (SQLException e) {
	            e.printStackTrace();
            }
        }
	}

	public List<Bug> findByUserId(Long userId) {
	    return null;
    }
}
