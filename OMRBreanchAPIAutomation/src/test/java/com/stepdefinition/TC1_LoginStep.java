package com.stepdefinition;

import java.io.IOException;

import org.junit.Assert;
import org.pojo.Login_Output_Pojo;

import com.baseclass.BaseClass;
import com.global.GlobalDatas;

import endpoints.Endpoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

/**
 * 
 * @author manoj
 * @Discription User can maintain steps to Login module
 * @Date 26-09-2022
 *
 */
public class TC1_LoginStep extends BaseClass {
	Response response;
	static GlobalDatas globalDatas = new GlobalDatas();

	/**
	 * @Discription User can add header
	 */
	@Given("User add header")
	public void user_add_header() {
		addHeader("accept", "application/json");
	}

	/**
	 * @Discription User can add basic authentication for login with username and
	 *              password
	 * @throws IOException
	 */
	@When("User add basic authentication for login")
	public void user_add_basic_authentication_for_login() throws IOException {
		basicAuth(getPropertyValue("username"), getPropertyValue("password"));
	}

	/**
	 * @Discription User can send request type for create request
	 * @param requestType
	 */
	@When("User send {string} request for login endpoint")
	public void user_send_request_for_login_endpoint(String requestType) {
		response = requestType(requestType, Endpoints.POSTMANBASICAUTHLOGIN);
		int statusCode = getStatusCode(response);
		globalDatas.setStatusCode(statusCode);
	}

	/**
	 * @Discription User can verify login respon
	 * 
	 * se firstname
	 * @param expFirstName
	 */
	@Then("User verify the login response body firstname present as {string} and get the logtoken saved")
	public void user_verify_the_login_response_body_firstname_present_as_and_get_the_logtoken_saved(
			String expFirstName) {
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String first_name = login_Output_Pojo.getData().getFirst_name();
		HooksClass.sc.log("Verify firstName in login endpoint"+" Exp Value: "+ expFirstName+" Actual Value: "+ first_name);
		Assert.assertEquals("Verify firstName in login endpoint", expFirstName, first_name);
		String logtoken = login_Output_Pojo.getData().getLogtoken();
		globalDatas.setLogToken(logtoken);
	}

}
