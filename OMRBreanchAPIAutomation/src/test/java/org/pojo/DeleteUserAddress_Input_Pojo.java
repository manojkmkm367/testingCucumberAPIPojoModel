package org.pojo;

/**
 * 
 * @author manoj
 * @description User can maintain the input parameters for delete address  
 * @date 26-09-2022
 *
 */
public class DeleteUserAddress_Input_Pojo {
	private String address_id;

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public DeleteUserAddress_Input_Pojo(String address_id) {
		super();
		this.address_id = address_id;
	}

}
