package com.daxia.mybug.model;

import java.sql.Date;

public class Bug {
	private int id; //bugID
	private String title; //标题
	private String content; //内容
	private int status; //状态
	private Date createDate; //日期
	private int user_id; //外键,关联用户
	
	public int getId()
	{
		return id;
	}
	
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public int getStatus()
	{
		return status;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
	public Date getCreateDate()
	{
		return createDate;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	public int getUser_id()
	{
		return user_id;
	}
	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}
}
