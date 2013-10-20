package com.daxia.mybug.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.daxia.mybug.dao.IBugDAO;
import com.daxia.mybug.db.DbUtils;
import com.daxia.mybug.model.Bug;

public class BugDAO implements IBugDAO
{
	//添加bug
	public boolean addBug(Bug bug)
	{
		Connection conn=null;
		try
		{
			conn=DbUtils.getConnection();
			String sql="insert into bt(titile,content,status,user_id) VALUES (?,?,?,?)";
			
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1, bug.getTitle());
			statement.setString(2, bug.getContent());
			statement.setInt(3, bug.getStatus());
			statement.setInt(4, bug.getUser_id());
			 
			int result=statement.executeUpdate();
			if(result>0){
				return true;
			}
		}catch(Exception ex)
		{
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
	
	//获取bug信息
	public List<Bug> getBugList(){
		List<Bug> list=new ArrayList<Bug>();
		Connection conn=null;
		try{
			conn=DbUtils.getConnection();
			String sql="SELECT *FROM bt";
			
			PreparedStatement statement=conn.prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				Bug bug=new Bug();
				bug.setTitle(rs.getString("titile"));
				bug.setContent(rs.getString("content"));
				bug.setStatus(rs.getInt("status"));
				bug.setCreateDate(rs.getDate("CreateDate"));
				
				list.add(bug);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return list;
	}
}
