package TestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC_001_Authentication_with_base_class extends BaseClass{
	
	// Note that if you need to add parameters, headers, cookies or other request properties use the given() method after RestAssured
	// ex. RestAssured.given().auth().basic("US", "PASS")
	
	@Test
	public void testBasic() {
	
		int stauscode= RestAssured.when().get().getStatusCode();
		System.out.println("Response code "+ stauscode);
	}
	
	@Test
	public void testBasicAllResponse() {
		String endpointResponse = RestAssured.when().get().asString();
		System.out.println(endpointResponse);
		
		
	}
	

}
