package testCase;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC_003_Get_Example {

	//@Test
	public void getCall() {
		RestAssured.given().get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad").then().statusCode(200);
	}

	// @Test
	public void getCallVerifyUsingAssertion() {
		int resCode = RestAssured.given().get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
				.getStatusCode();
		Assert.assertEquals(HttpStatus.SC_OK, resCode);
	}

	 @Test
	public void fetchResponse() {
		RestAssured.given().get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad").then().
				log().all();
	}

	// @Test
	public void fetchResponse2() {

		Response response = RestAssured.given().get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad");
		System.out.println("Response Body is =>  " + response.asString());

	}

	// @Test
	public void passParameter() {
		RestAssured.given().
		param("Key", "value").and()
		.header("Content-Type", "application/json").and()
		.when()
		.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad").then().statusCode(HttpStatus.SC_OK);
	}

	 //@Test
	public void GetWeatherStatusLine() {
		Response res = RestAssured.given().get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad");
		String statusLine = res.getStatusLine();
		System.out.println("Your status line is " + statusLine);
		System.out.println("Your response body is " + res.asString());
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	
}
