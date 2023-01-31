package com.global;

/**
 * 
 * @author manoj 
 * @Discription User can maintain parameter accessible to all parts of the program
 * @Date 26-09-2022
 */
public class GlobalDatas {

	private int statusCode;
	private String logToken;

	
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getLogToken() {
		return logToken;
	}

	public void setLogToken(String logToken) {
		this.logToken = logToken;
	}

}
