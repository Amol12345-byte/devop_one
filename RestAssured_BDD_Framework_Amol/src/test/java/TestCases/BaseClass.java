package TestCases;

import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;

public class BaseClass {
	
	@BeforeClass
	
	public void setUp() {
	
		RestAssured.baseURI =  "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		RestAssured.authentication = RestAssured.preemptive().basic("ToolsQA", "TestPassword");

	}

}
