package com.daxia.mybug.common;

public enum BugPriority {
	Normal(0), 
	Critical(1), 
	Urgent(2);

	private int value;

	private BugPriority(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
