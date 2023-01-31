package com.stepdefinition;

import org.junit.Assert;

import io.cucumber.java.en.Then;

/**
 * 
 * @author manoj
 * @Discription User can maintain common steps for all scenarios
 *
 */

public class CommonStep {

	/**
	 * @Description Asserts that two string are equal or not
	 * @param Expected condition
	 */
	@Then("User verify the status code is {int}")
	public void user_verify_the_status_code_is(int expCode) {
		System.out.println(TC1_LoginStep.globalDatas.getStatusCode());
		Assert.assertEquals("Verify statusCode", expCode, TC1_LoginStep.globalDatas.getStatusCode());

	}

}
