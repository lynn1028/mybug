package com.daxia.mybug.service;

import java.util.List;

import com.daxia.mybug.dao.BugDAO;
import com.daxia.mybug.model.Bug;

public class BugService {
	private BugDAO bugDAO = new BugDAO();
	
	public void add(Bug bug) {
		bugDAO.add(bug);
    }

	public List<Bug> findByUserId(Long userId) {
	    return bugDAO.findByUserId(userId);
    }

}
