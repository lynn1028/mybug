package com.daxia.mybug.service;

import java.util.List;

import com.daxia.mybug.dao.IBugDAO;
import com.daxia.mybug.dao.impl.BugDAO;
import com.daxia.mybug.model.Bug;



public class BugService {
	private IBugDAO bugDao=null;
	
	public BugService(){
		this.bugDao=new BugDAO();
	}
	
	//添加账户
	public boolean addBug(Bug bug) throws Exception
	{
		return bugDao.addBug(bug);
	}
	
	//获取bug列表
	public List<Bug> hostBugList() throws Exception
	{
		List<Bug> list=bugDao.getBugList();
		return list;
	}
}
