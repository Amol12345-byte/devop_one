package TestCases;

import static org.testng.Assert.assertEquals;

import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_005_PUT_Service {
	
	@Test
	public void userdetailsUpdate() {
		RestAssured.baseURI= "https://reqres.in/api";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		
		// JSON body value contains 
		JSONObject json_BodyValue = new JSONObject();
		json_BodyValue.put("name", "APITest");
		json_BodyValue.put("job", "APIDetails");
		request.body(json_BodyValue.toJSONString());
		
		Response requ = request.put("/users/2");
		int statuscode = requ.getStatusCode();
		System.out.println("API status code printed--> "+statuscode);
		assertEquals(HttpStatus.SC_OK, 200);			
	}
}
