package TestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC_002_Get_response {
	
	@Test
	
	public void getCall() {
		RestAssured.given().get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad").then().statusCode(200);

	}
	
	// getting all response header & Json body from API
	@Test
	public void getAllFetchResponse() {
		RestAssured.given().get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad").then().log().all();
		System.out.println("Log sucessfully genearted for all getAllFetchResponse");
		System.out.println("********************************************");
	}
	
	// only getting Json body part from API
	@Test
	public void getJsonBodyResponse() {
		Response resopnseAll = RestAssured.given().get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad");
		System.out.println("FetchRespose from --> "+resopnseAll.asString());
		System.out.println("********************************************");
	}	
	
	// Passing parameter into header part
	@Test
	public void paraPassResponse() {
		Response resp = RestAssured.given().param("Key", "value").and().header("Content-Type", "application/json")
		.and().header("Accept", "application/json")
		.when().get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad");
		
		System.out.println("Parapass response-->"+resp.asString());
		System.out.println("********************************************");
	}
}
