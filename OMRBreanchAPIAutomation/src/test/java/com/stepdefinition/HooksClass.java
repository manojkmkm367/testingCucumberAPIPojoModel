package com.stepdefinition;

import java.io.IOException;
import java.time.Duration;

import com.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * 
 * @author manoj
 * @Discription User can maintain common function to perform before and after
 *              each Scenario
 */
public class HooksClass extends BaseClass {

	static Scenario sc;

	/**
	 * @Discription Used to perform common function before each Scenario
	 * @throws IOException
	 */
	@Before
	public void beforeScenario(Scenario scenario) {
		sc = scenario;
	}

	/**
	 * @Discription Used to perform common function before each Scenario
	 * @param scenario
	 */
	@After
	public void afterScenario(Scenario scenario) {

		scenario.log(getResBodyAsPrettyString(response));

	}

}
