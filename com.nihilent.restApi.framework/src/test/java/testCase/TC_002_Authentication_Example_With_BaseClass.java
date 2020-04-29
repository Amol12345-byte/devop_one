package testCase;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC_002_Authentication_Example_With_BaseClass extends BaseClass {
	
	@Test
	public void testBasic() {
		int code = RestAssured.given().get().getStatusCode();
		 System.out.println("The Status code is: " + code);
	}
}
