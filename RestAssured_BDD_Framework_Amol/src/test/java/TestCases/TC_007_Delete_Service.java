package TestCases;

import static org.testng.Assert.assertEquals;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_007_Delete_Service {
	
	@Test
	public void userDeleteService() {
		RestAssured.baseURI="https://reqres.in/api";
		RequestSpecification requDelete = RestAssured.given();
		requDelete.header("Content-Type","application/json");
				
		Response respDelete = requDelete.delete("/users/2");
		int statscodedelete = respDelete.getStatusCode();
		System.out.println("Delete service API -->"+statscodedelete);
		assertEquals(HttpStatus.SC_NO_CONTENT, 204);		
	}

}
