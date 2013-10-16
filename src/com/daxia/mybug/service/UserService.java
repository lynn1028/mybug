package com.daxia.mybug.service;

import java.util.List;

import com.daxia.mybug.dao.UserDAO;
import com.daxia.mybug.model.User;

public class UserService {
	
	private UserDAO userDAO = new UserDAO();
	
	public void add(User user) throws Exception {
		userDAO.add(user);
	}
	
	public User login(String username, String password) {
		return userDAO.findByUsernameAndPassword(username, password);
	}

	public List<User> findAll() {
		return userDAO.findAll();
    }
}
