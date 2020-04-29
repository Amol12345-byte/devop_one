package TestCases;

import static org.testng.Assert.assertEquals;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class TC_001_Authentication_without_base_class {
	
	// BDD framework with given, when, then & and keyword 
	// Preemptive Authentication 
	@Test  
	public void auth_preemptive_Authentication() {
		int statuscode = RestAssured.given().auth().preemptive().basic("ToolsQA", "TestPassword")
		.when().get("http://restapi.demoqa.com/authentication/CheckForAuthentication")
		.getStatusCode();
		
		assertEquals(HttpStatus.SC_OK, statuscode);
	}
	
	//Basic Authentication
	@Test
	public void auth_basic_Authentication() {
		int statucode = RestAssured.given().auth().basic("ToolsQA", "TestPassword")
		.when().get("http://restapi.demoqa.com/authentication/CheckForAuthentication")
		.getStatusCode();
		
		assertEquals(HttpStatus.SC_OK, statucode);
	}
	
	//Digestive Authentication convert US & PASS into encryption form
	@Test
	public void auth_Digestive_Authentication() {
		int stauscode = RestAssured.given().auth().digest("ToolsQA", "TestPassword")
		.when().get("http://restapi.demoqa.com/authentication/CheckForAuthentication")
		.getStatusCode();
		
		System.out.println("Response code "+ stauscode);
	}
		
}
