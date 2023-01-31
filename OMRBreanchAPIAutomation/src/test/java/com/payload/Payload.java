package com.payload;

import org.pojo.AddUserAddress_Input_Pojo;
import org.pojo.DeleteUserAddress_Input_Pojo;
import org.pojo.SearchProduct_Input_Pojo;
import org.pojo.UpdateUserAddress_Input_Pojo;

/**
 * 
 * @author manoj
 * @description User can maintain data want to transporting to the server when
 *              you make an API request
 * @date 26-09-2022
 *
 */

public class Payload {
	/**
	 * @description Object for maintain data want to transporting to the server when
	 *              for add new address
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 * @return Object
	 */

	public AddUserAddress_Input_Pojo addUserAddress(String first_name, String last_name, String mobile,
			String apartment, int state, int city, int country, String zipcode, String address, String address_type) {

		AddUserAddress_Input_Pojo address_Input_Pojo = new AddUserAddress_Input_Pojo(first_name, last_name, mobile,
				apartment, state, city, country, zipcode, address, address_type);

		return address_Input_Pojo;
	}

	/**
	 * @description Object for maintain data want to transporting to the server for
	 *              update existing address
	 * @param address_id
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 * @return Object
	 */
	public UpdateUserAddress_Input_Pojo updateUserAddress(String address_id, String first_name, String last_name,
			String mobile, String apartment, int state, int city, int country, String zipcode, String address,
			String address_type) {
		UpdateUserAddress_Input_Pojo updateaddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(address_id, first_name,
				last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		return updateaddress_Input_Pojo;
	}

	/**
	 * @Description Object for maintain data want to transporting to the server for
	 *              deleting existing address
	 * @param address_id
	 * @return
	 */
	public DeleteUserAddress_Input_Pojo deleteUserAddress(String address_id) {
		DeleteUserAddress_Input_Pojo deleteaddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(address_id);
		return deleteaddress_Input_Pojo;
	}

	/**
	 * @Description Object for maintain data want to transporting to the server for
	 *              search product
	 * @param product
	 * @return
	 */
	public SearchProduct_Input_Pojo searchProduct(String product) {
		SearchProduct_Input_Pojo input_Pojo = new SearchProduct_Input_Pojo(product);

		return input_Pojo;
	}

}
