package org.pojo;


/**
 * 
 * @author manoj
 * @description User can maintain the output parameters for getting update profile picture  
 * @date 26-09-2022
 *
 */
public class UpdateProfilePic_Output_Pojo {
	 private int status;
	 private String message;
	 private ProfilePicData data;
	 private int cart_count;
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
	public ProfilePicData getData() {
		return data;
	}
	public void setData(ProfilePicData data) {
		this.data = data;
	}
	public int getCart_count() {
		return cart_count;
	}
	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}
	 
}
