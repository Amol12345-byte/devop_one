package testCase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_007_Delete_Example {
	
	@Test
	public void putEx() {
	RestAssured.baseURI ="http://localhost:3000";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "application/json");

	Response response = request.delete("/posts/2");

	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 200);

	}
}
