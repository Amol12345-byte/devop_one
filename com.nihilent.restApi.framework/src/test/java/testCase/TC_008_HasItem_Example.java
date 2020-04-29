package testCase;

import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC_008_HasItem_Example {

	@Test
	public void hasItem() {
		Response response = RestAssured.given().get("https://jsonplaceholder.typicode.com/posts");

		Headers allHeaders = response.getHeaders();
		String headerName = response.getHeader("Connection");
		System.out.println(headerName);
		System.out.println(allHeaders);
		
		Map<String, String> allCookies = response.getCookies();
		String cookieValue = response.getCookie("cookieName");
		System.out.println(cookieValue);
		System.out.println(allCookies);
		
		String statusLine = response.getStatusLine();
		int statusCode = response.getStatusCode();
	}
}
