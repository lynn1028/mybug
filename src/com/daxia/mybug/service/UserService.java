package com.daxia.mybug.service;

import com.daxia.mybug.dao.IUserDAO;
import com.daxia.mybug.dao.impl.UserDAO;
import com.daxia.mybug.model.User;

public class UserService {
	private IUserDAO ud=null;
	
	public UserService(){
		this.ud=new UserDAO();
	}
	
	//添加用户
	public boolean add(User user) {
		return ud.add(user);
	}
	
	//用户登录
	public User login(String username, String password) {
		return ud.findByUsernameAndPassword(username, password);
	}
}
