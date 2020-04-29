package testCase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_005_POST_Example {

	@Test
	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="http://localhost:3000/posts";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("id", "3");
		json.put("title", "aaaaaaaaaaaaaaaaaaaa");
		json.put("author", "Rashmi");
		
		request.body(json.toJSONString());
		Response response = request.post("/3");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
	}
}
