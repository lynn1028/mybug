package com.daxia.mybug.dao;

import java.util.List;

import com.daxia.mybug.model.Bug;

public interface IBugDAO
{
	/**
	 * 添加bug
	 * @param bug 传入bug对象
	 * @return 验证操作结果
	 * */
	public boolean addBug(Bug bug);
	
	/**
	 * 获取bug列表
	 * @return bug list(bug列表)
	 * */
	public List<Bug> getBugList();
}
