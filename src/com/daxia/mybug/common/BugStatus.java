package com.daxia.mybug.common;

public enum BugStatus {
	Active(0),
	Fixed(1),
	Closed(2);
	
	private int value;
	private BugStatus(int value) {
		this.value = value;
    }
	
	public int getValue() {
		return value;
	}
}
