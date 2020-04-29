package testCase;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

	@Test
	public void simpleMessageTest(){
	    RequestSpecification requestSpec = new RequestSpecBuilder()
	            .setBaseUri("http://localhost")
	            .setBasePath("/simple-app/slack/message")
	            .setPort(8080)
	            .setBody("Message from "+this.getClass().getName())
	            .setContentType("application/json")
	            .setAccept("text/plain")
	            .build();
	    
	    String r = RestAssured.given().spec(requestSpec).when().post().andReturn().body().asString();
	    Response res = RestAssured.given().spec(requestSpec).when().post();
	    res.getStatusCode();
	}
}
