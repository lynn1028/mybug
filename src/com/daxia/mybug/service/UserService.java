package com.daxia.mybug.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.daxia.mybug.db.DbUtils;
import com.daxia.mybug.model.User;

public class UserService {
	
	public void add(User user) throws Exception {
		String sql = "insert into user(xxx, xxx) values(?, ?)";
		Connection connection = DbUtils.getConnection();
		
		PreparedStatement statement = connection.prepareStatement(sql);
		// 将sql里的问号替换成值, 如
		// statement.setLong(0, user.getId());
		
		statement.execute();
		
	}
}
