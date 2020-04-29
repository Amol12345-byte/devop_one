package TestCases;

import static org.testng.Assert.assertEquals;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_004_POST_Service {
	
	@Test
	public void adduserdetails() {
		
		RestAssured.baseURI =  "https://reqres.in/api";
		RequestSpecification request= RestAssured.given(); 
		request.header("Content-Type","application/json");
		
		// Writing JSON value in the body part 
		JSONObject jsonvalue = new JSONObject();
		jsonvalue.put("name", "TestAPI");
		jsonvalue.put("job", "APITEST");				
		request.body(jsonvalue.toJSONString());
		
		Response responseAPI = request.post("/users");
		
		int statuscodeAPI = responseAPI.getStatusCode();
		System.out.println("Status code printed for POST service -->"+statuscodeAPI);
		assertEquals(statuscodeAPI, 201);		
	}
}
