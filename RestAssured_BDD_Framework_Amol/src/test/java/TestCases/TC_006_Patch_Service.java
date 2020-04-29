package TestCases;

import static org.testng.Assert.assertEquals;

import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_006_Patch_Service {
	
	@Test
	public void userDeleteDervice() {
		
		RestAssured.baseURI= "https://reqres.in/api";
		RequestSpecification requPatch = RestAssured.given();
		requPatch.header("Content-Type","application/json");
		
		JSONObject jsonbodyPatch = new JSONObject();
		jsonbodyPatch.put("name", "PATCHAPI");
		requPatch.body(jsonbodyPatch.toJSONString());
		
		
		Response respPatch = requPatch.patch("/users/2");
		int Patchstatuscode= respPatch.getStatusCode();
		System.out.println("Patch service status code-->"+Patchstatuscode);
		assertEquals(HttpStatus.SC_OK, 200);
		
		
	}

}
