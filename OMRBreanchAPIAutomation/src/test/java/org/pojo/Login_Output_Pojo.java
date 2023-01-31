package org.pojo;

import java.util.ArrayList;

/**
 * 
 * @author manoj
 * @description User can maintain the output parameters for getting login authentication response  
 * @date 26-09-2022
 *
 */
public class Login_Output_Pojo {

	private int status;
	private String message;
	private Data data;
	private String refer_msg;
	private int cart_count;
	private String role;

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public Data getData() {
		return data;
	}

	public String getRefer_msg() {
		return refer_msg;
	}

	public int getCart_count() {
		return cart_count;
	}

	public String getRole() {
		return role;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public void setRefer_msg(String refer_msg) {
		this.refer_msg = refer_msg;
	}

	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
