package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.pojo.AddUserAddress_Input_Pojo;
import org.pojo.AddUserAddress_Output_Pojo;
import org.pojo.DeleteUserAddress_Input_Pojo;
import org.pojo.DeleteUserAddress_Output_Pojo;
import org.pojo.GetUserAddress_Output_Pojo;
import org.pojo.UpdateUserAddress_Input_Pojo;
import org.pojo.UpdateUserAddress_Output_Pojo;

import com.baseclass.BaseClass;
import com.payload.Payload;

import endpoints.Endpoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * 
 * @author manoj
 * @Discription User can maintain steps to validate Address module
 * @Date 26-09-2022
 *
 */
public class TC2_AddressStep extends BaseClass {
	static String address_id;
	Response response;
//	static String message;
	static Payload payload = new Payload();

	/**
	 * @Discription User can add header & bearer authentication for create a header
	 */
	@Given("User add header and bearer authentication for accessing address endpoint")
	public void user_add_header_and_bearer_authentication_for_accessing_address_endpoint() {

		List<Header> h = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogToken());
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);

		Headers headers = new Headers(h);
		addHeaders(headers);
	}

	/**
	 * @Discription User can add request body for create new address
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
	 */
	@When("User add request body for new address {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string} and {string}")
	public void user_add_request_body_for_new_address_and(String first_name, String last_name, String mobile,
			String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {

		int intState = Integer.parseInt(state);
		int intCity = Integer.parseInt(city);
		int intCountry = Integer.parseInt(country);

		AddUserAddress_Input_Pojo addUserAddressInput = payload.addUserAddress(first_name, last_name, mobile, apartment,
				intState, intCity, intCountry, zipcode, address, address_type);

		addBody(addUserAddressInput);
	}

	/**
	 * @Discription User can send request for add user address
	 * @param addRequest
	 */
	@When("User send a {string} request for addUserAddress endpoint")
	public void user_send_a_request_for_add_user_address_endpoint(String addRequest) {
		response = requestType(addRequest, Endpoints.ADDUSERADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	@When("User update request body for existing address {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string} and {string}")
	public void user_update_request_body_for_existing_address_and(String id, String first_name, String last_name,
			String mobile, String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {
		int intState = Integer.parseInt(state);
		int intCity = Integer.parseInt(city);
		int intCountry = Integer.parseInt(country);
		UpdateUserAddress_Input_Pojo update_address_Input_Pojo = payload.updateUserAddress(address_id, first_name,
				last_name, mobile, apartment, intState, intCity, intCountry, zipcode, address, address_type);

		addBody(update_address_Input_Pojo);

	}

	/**
	 * @Discription User can send update request to updating existing address
	 * @param updateRequest
	 */
	@When("User send a {string} request for updateUserAddress endpoint")
	public void user_send_a_request_for_update_user_address_endpoint(String updateRequest) {
		response = requestType(updateRequest, Endpoints.UPDATEUSERADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	/**
	 * @Discription User can send request for getting all user address
	 * @param getRequest
	 */
	@When("User send a {string} request for getUserAddress endpoint")
	public void user_send_a_request_for_get_user_address_endpoint(String getRequest) {
		response = requestType(getRequest, Endpoints.GETUSERADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	/**
	 * @Discription User can add input to delete existing address
	 */
	@When("User delete request body for existing address")
	public void user_delete_request_body_for_existing_address() {
		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = payload.deleteUserAddress(address_id);
		addBody(deleteUserAddress_Input_Pojo);
	}

	/**
	 * @Discription User send request for delete existing address
	 * @param deleteRequest
	 */
	@When("User send a {string} request for deleteUserAddress endpoint")
	public void user_send_a_request_for_delete_user_address_endpoint(String deleteRequest) {
		response = requestType(deleteRequest, Endpoints.DELETEUSERADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

//	/**
//	 * @Discription User can verify the authentication response message matches with
//	 *              expected
//	 * @param expMessage
//	 */
//	@Then("User verify the authentication response message matches {string}")
//	public void user_verify_the_authentication_response_message_matches(String expMessage) {
//		HooksClass.sc.log("Verify authentication response message"+" Exp Value: "+ message+" Actual Value: "+ expMessage);
//		Assert.assertEquals("Verify authentication response message", expMessage, message);
//	}

	/**
	 * @Discription User can verify the add new address response message matches
	 *              with expected
	 * @param expString
	 */
	@Then("User verify the add new address response message matches {string}")
	public void user_verify_the_add_new_address_response_message_matches(String expString) {
		AddUserAddress_Output_Pojo address_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		String message = address_Output_Pojo.getMessage();
		address_id = Integer.toString(address_Output_Pojo.getAddress_id());
		HooksClass.sc.log(
				"Verify add new address response message" + " Exp Value: " + expString + " Actual Value: " + message);
		Assert.assertEquals("Verify add new address response message", expString, message);
	}

	/**
	 * @Discription User can verify the update address response message matches
	 *              with expected
	 * @param expString
	 */
	@Then("User verify the update address response message matches {string}")
	public void user_verify_the_update_address_response_message_matches(String expString) {
		UpdateUserAddress_Output_Pojo update_output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);
		String message = update_output_Pojo.getMessage();
		HooksClass.sc.log(
				"Verify update address response message" + " Exp Value: " + expString + " Actual Value: " + message);
		Assert.assertEquals("Verify update address response message", expString, message);

	}

	/**
	 * @Discription User can verify the get address response message matches
	 *              with expected
	 * @param expString
	 */
	@Then("User verify the get address response message matches {string}")
	public void user_verify_the_get_address_response_message_matches(String expString) {
		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
		String message = getUserAddress_Output_Pojo.getMessage();
		HooksClass.sc
				.log("Verify get address response message" + " Exp Value: " + expString + " Actual Value: " + message);
		Assert.assertEquals("Verify get address response message", expString, message);
	}

	/**
	 * @Discription User can verify the delete address response message matches
	 *              with expected
	 * @param expString
	 */
	@Then("User verify the delete address response message matches {string}")
	public void user_verify_the_delete_address_response_message_matches(String expString) {
		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
		String message = deleteUserAddress_Output_Pojo.getMessage();
		HooksClass.sc.log(
				"Verify delete address response message" + " Exp Value: " + expString + " Actual Value: " + message);
		Assert.assertEquals("Verify delete address response message", expString, message);
	}

}
