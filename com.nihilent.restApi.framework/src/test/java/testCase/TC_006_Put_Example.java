package testCase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_006_Put_Example {

	@Test
	public void putEx() {
	RestAssured.baseURI ="http://localhost:3000";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "application/json");

	JSONObject json = new JSONObject();
	json.put("id", "2");
	json.put("title", "RestAssured-Training");
	json.put("author", "amol");
	

	request.body(json.toJSONString());
	Response response = request.put("/posts/2");

	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 200);

	}

}
