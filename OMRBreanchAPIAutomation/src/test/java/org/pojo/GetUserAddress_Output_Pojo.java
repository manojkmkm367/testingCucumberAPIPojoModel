package org.pojo;

import java.util.ArrayList;

/**
 * 
 * @author manoj
 * @description User can maintain the output parameters for getting user address  
 * @date 26-09-2022
 *
 */
public class GetUserAddress_Output_Pojo {
	private int status;
	private String message;
	private ArrayList<UserDatum> data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<UserDatum> getData() {
		return data;
	}

	public void setData(ArrayList<UserDatum> data) {
		this.data = data;
	}

}
