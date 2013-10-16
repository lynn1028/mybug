package com.daxia.mybug.model;

public class Bug {
	private Long id;
	private String title;
	private String content;
	private int status;
	private int priority;
	private long userId;
	
	/**
     * @return the id
     */
    public Long getId() {
    	return id;
    }
	/**
     * @param id the id to set
     */
    public void setId(Long id) {
    	this.id = id;
    }
	/**
     * @return the title
     */
    public String getTitle() {
    	return title;
    }
	/**
     * @param title the title to set
     */
    public void setTitle(String title) {
    	this.title = title;
    }
	/**
     * @return the content
     */
    public String getContent() {
    	return content;
    }
	/**
     * @param content the content to set
     */
    public void setContent(String content) {
    	this.content = content;
    }
	/**
     * @return the status
     */
    public int getStatus() {
    	return status;
    }
	/**
     * @param status the status to set
     */
    public void setStatus(int status) {
    	this.status = status;
    }

	/**
     * @return the priority
     */
    public int getPriority() {
    	return priority;
    }
	/**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
    	this.priority = priority;
    }
	/**
     * @return the userId
     */
    public long getUserId() {
    	return userId;
    }
	/**
     * @param userId the userId to set
     */
    public void setUserId(long userId) {
    	this.userId = userId;
    }
	
	

}
