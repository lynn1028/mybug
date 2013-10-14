package com.daxia.mybug.exception;

public class MyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MyException() {
    }
    
    public MyException(String msg, Throwable e) {
    	super(msg, e);
    }
}
