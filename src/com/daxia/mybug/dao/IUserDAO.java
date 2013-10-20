package com.daxia.mybug.dao;

import com.daxia.mybug.model.User;

public interface IUserDAO
{
	/**
	 * 用户身份验证
	 * @param userName 用户名
	 * @param password 密码
	 * @return User对象
	 * */
	public User findByUsernameAndPassword(String userName,String password);
	
	/**
	 * 添加用户
	 * @param user 对象
	 * @return 验证的操作结果
	 * */
	public boolean add(User user);
}
