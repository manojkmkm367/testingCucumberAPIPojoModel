package com.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.pojo.UpdateProfilePic_Output_Pojo;

import com.baseclass.BaseClass;
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
 * @Discription User can maintain steps to validate change profile picture
 * @Date 26-09-2022
 *
 */
public class TC3_ChangeProfilePicStep extends BaseClass {
	Response response;

	/**
	 * @Discription User can add header and bearer authentication
	 */
	@Given("User add header and bearer authentication for accessing profile picture endpoint")
	public void user_add_header_and_bearer_authentication_for_accessing_profile_picture_endpoint() {
		List<Header> h = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogToken());
		Header h3 = new Header("Content-Type", "multipart/form-data");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers headers = new Headers(h);
		addHeaders(headers);
	}

	/**
	 * @Discription User can add request body for changing Profile picture
	 * @throws IOException
	 */
	@When("User add request body for changing Profile picture")
	public void user_add_request_body_for_changing_profile_picture() throws IOException {
		formData("profile_picture", new File(System.getProperty("user.dir") + getPropertyValue("profilePic")));
	}

	/**
	 * @Discription User can send request to change profile pictute
	 * @param profilePicRequest
	 */
	@When("User send a {string} request for changeProfilePicture endpoint")
	public void user_send_a_request_for_change_profile_picture_endpoint(String profilePicRequest) {
		response = requestType(profilePicRequest, Endpoints.CHANGEPROFILEPIC);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	/**
	 * @Discription User can verify the change address response message matches with
	 *              expected
	 * @param expString
	 */
	@Then("User verify the change Profile response message matches {string}")
	public void user_verify_the_change_profile_response_message_matches(String expString) {
		UpdateProfilePic_Output_Pojo profilePic_Output_Pojo = response.as(UpdateProfilePic_Output_Pojo.class);
		String message = profilePic_Output_Pojo.getMessage();
		HooksClass.sc.log("Verify change Profile Picture response message" + " Exp Value: " + expString
				+ " Actual Value: " + message);
		Assert.assertEquals("Verify change Profile Picture response message", expString, message);
	}

}
