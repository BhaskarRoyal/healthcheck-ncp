package com.pcehr.ao.global.exception;

public class HealthCheckException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message=null;

	public HealthCheckException(String message) {
		super(message);
		this.message = message;
	}
	
	public HealthCheckException(String message,Throwable e) {
		super(message,e);
		this.message = message;
	}
	
	public HealthCheckException(Throwable e) {
		super(e);
		this.message = e.getMessage();
	}


	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
