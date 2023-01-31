package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author manoj
 * @description User can maintain the reusable method
 * @date 26-09-2022
 * 
 */

public class BaseClass {

	RequestSpecification reqspec;
	public static Response response;

	/**
	 * @Description use to read the data from properties file
	 * @param key
	 * @return sTRING
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getPropertyValue(String key) throws IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\config\\Config.properties"));
		return (String) properties.get(key);

	}

	/**
	 * @Description used to Specify a file to upload to the server using multi-part
	 * @param key
	 * @param value
	 */
	public void formData(String key, File value) {
		reqspec = reqspec.multiPart(key, value);

	}

	/**
	 * @Description used to Specify header to the application
	 * @param Key
	 * @param Value
	 */
	public void addHeader(String Key, String Value) {
		reqspec = RestAssured.given().header(Key, Value);
	}

	/**
	 * @Description used to create several headers with different value
	 * @param headers
	 */
	public void addHeaders(Headers headers) {
		reqspec = RestAssured.given().headers(headers);

	}

	/**
	 * @Description Specify an Object request content that will automatically be
	 *              serialized to JSON application body
	 * @param body
	 */
	public void addBody(Object body) {
		reqspec = reqspec.body(body);
	}

	/**
	 * @Description used to authenticate encoded credentials
	 * @param usereName
	 * @param Password
	 */
	public void basicAuth(String usereName, String Password) {
		reqspec.auth().preemptive().basic(usereName, Password);
	}

	/**
	 * @Description used to Specify a query parameter that'll be sent with the
	 *              request
	 * @param Key
	 * @param Value
	 */
	public void queryParam(String Key, String Value) {
		reqspec = reqspec.queryParam(Key, Value);
	}

	/**
	 * @Description Used to Specify a path parameter that'll be sent with the
	 *              request
	 * @param Key
	 * @param Value
	 */
	public void pathParam(String Key, String Value) {
		reqspec = reqspec.pathParam(Key, Value);
	}

	/**
	 * @Description used to specify request body
	 * @param body
	 */
	public void addBody(String body) {
		reqspec = reqspec.body(body);
	}

	/**
	 * @Description Used can Perform a specified request to a given endpint
	 * @param type
	 * @param endpoint
	 * @return Response
	 */
	public Response requestType(String type, String endpoint) {
		switch (type) {
		case "GET":
			response = reqspec.log().all().get(endpoint);
			break;

		case "POST":
			response = reqspec.log().all().post(endpoint);
			break;

		case "PUT":
			response = reqspec.log().all().put(endpoint);
			break;

		case "DELETE":
			response = reqspec.log().all().delete(endpoint);
			break;
		default:
			break;
		}
		return response;
	}

	/**
	 * @Description Used to Get the status code of the response
	 * @param response
	 * @return statusCode
	 */
	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	/**
	 * @Description Used to get the response body as a string.
	 * @param response
	 * @return String
	 */
	public String getResBodyAsString(Response response) {
		String asString = response.asString();
		return asString;
	}

	/**
	 * @Description used to get the response body as pretty formatted string
	 * @param response
	 * @return String
	 */
	public String getResBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}

}