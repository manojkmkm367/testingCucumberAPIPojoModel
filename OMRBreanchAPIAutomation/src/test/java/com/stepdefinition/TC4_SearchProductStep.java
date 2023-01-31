package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.pojo.SearchProduct_Input_Pojo;
import org.pojo.SearchProduct_Output_Pojo;

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
 * @Discription User can maintain steps to validate search product steps
 * @Date 26-09-2022
 *
 */
public class TC4_SearchProductStep extends BaseClass {
	Response response;
	static Payload payload = new Payload();

	/**
	 * @Discription User can add header and bearer authentication
	 */
	@Given("User add header and bearer authentication for accessing search product endpoint")
	public void user_add_header_and_bearer_authentication_for_accessing_search_product_endpoint() {
		List<Header> h = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);
	}

	/**
	 * @Discription User can add request body for search product
	 * @param product
	 */
	@When("User add request body for search product {string}")
	public void user_add_request_body_for_search_product(String product) {
		SearchProduct_Input_Pojo searchProduct = payload.searchProduct(product);
		addBody(searchProduct);
	}

	/**
	 * @Discription User can send a request for search product
	 * @param searchReq
	 */
	@When("User send a {string} request for searchProduct endpoint")
	public void user_send_a_request_for_search_product_endpoint(String searchReq) {
		response = requestType(searchReq, Endpoints.SEARCHPRODUCT);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	/**
	 * @Discription User can verify the Search Product response message matches with
	 *              expected
	 * @param expString
	 */
	@Then("User verify the Search Product response message matches {string}")
	public void user_verify_the_search_product_response_message_matches(String expString) {
		SearchProduct_Output_Pojo product_Output_Pojo = response.as(SearchProduct_Output_Pojo.class);
		String message = product_Output_Pojo.getMessage();
		HooksClass.sc.log(
				"Verify Search Product response message" + " Exp Value: " + expString + " Actual Value: " + message);
		Assert.assertEquals("Verify Search Product response message", expString, message);
	}

}
