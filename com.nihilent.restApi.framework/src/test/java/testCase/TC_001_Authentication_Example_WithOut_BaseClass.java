package testCase;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class TC_001_Authentication_Example_WithOut_BaseClass {

	@Test
	public void demo() {
		int code = RestAssured.given()
				.auth().preemptive()
				.basic("ToolsQ", "TestPassword")
				.when()
				.get("http://restapi.demoqa.com/authentication/CheckForAuthentication")
				.getStatusCode();
		
		Assert.assertEquals(HttpStatus.SC_OK, code);
	}
	
	//@Test
	public void testBasic_Challenged_Authentication() {
		int code = RestAssured.given().auth().basic("ToolsQA", "TestPassword").when().get("http://restapi.demoqa.com/authentication/CheckForAuthentication").getStatusCode();
		System.out.println("Your status code is " +code);
	}
	
	//@Test
	public void testDigestive_Authentication() {
		int code = RestAssured.given().auth().digest("ToolsQA", "TestPassword").when().get("http://restapi.demoqa.com/authentication/CheckForAuthentication").getStatusCode();
		System.out.println("Your status code is " +code);
	}
}
