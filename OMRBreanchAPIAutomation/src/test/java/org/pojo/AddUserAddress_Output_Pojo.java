package org.pojo;


/**
 * 
 * @author manoj
 * @description User can maintain the output parameters to get the response for new created address  
 * @date 26-09-2022
 *
 */
public class AddUserAddress_Output_Pojo {
	private int status;
	private String message;
	private int address_id;

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

}
