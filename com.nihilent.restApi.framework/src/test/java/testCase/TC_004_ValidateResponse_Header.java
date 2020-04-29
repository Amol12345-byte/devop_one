package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC_004_ValidateResponse_Header {

	   @Test
		public void GetWeatherHeaders()
		{
		 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		 RestAssured.given();
		 Response response = RestAssured.get("/Hyderabad");
		 
		 String contentType = response.header("Content-Encoding");
		 System.out.println("Content-Type value: " + contentType);
		 
		 String serverVal =  response.header("Server");
		 System.out.println("Server value: " + serverVal);
		 
		 String contentLength = response.header("Content-Length");
		 System.out.println("Content-Length is : " + contentLength);
		}

		//@Test
		public void validateResponseBody()
		{
			RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
			RestAssured.given();
			Response response = RestAssured.get("/Hyderabad");

			JsonPath jsonPathEvaluator = response.jsonPath();
			String city = jsonPathEvaluator.get("City");

			System.out.println(city);
			Assert.assertEquals(city, "Hyderabad");
		}
		
		//@Test
		public void validateNodeWise()
		{
			RestAssured.baseURI = "https://reqres.in/api/users";
			RestAssured.given();
			Response response = RestAssured.get("?page=2");

			JsonPath jsonPathEvaluator = response.jsonPath();
			int id = jsonPathEvaluator.get("data[0].id");

			System.out.println("Your id is "+id);
			Assert.assertEquals(id, 7);
		}
}
