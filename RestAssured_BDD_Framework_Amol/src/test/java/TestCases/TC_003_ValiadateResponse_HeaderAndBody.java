package TestCases;

import java.security.PublicKey;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TC_003_ValiadateResponse_HeaderAndBody {
	
	@Test
	public void ValidateResponse_NodeWiseOfHeader() {
		RestAssured.baseURI= "https://reqres.in//api/users";
		RestAssured.given();
		Response responseofURI= RestAssured.get("?page=2");
		
		String headerValue1 = responseofURI.header("Content-Type");
		System.out.println("Header shows some value--"+headerValue1);
		
		String headerValue2 = responseofURI.header("Transfer-Encoding");
		System.out.println("Header shows some value--"+headerValue2);
		
		String headerValue3 = responseofURI.header("Vary");
		System.out.println("Header shows some value--"+headerValue3);
		
		String headerValue4 = responseofURI.header("Content-Encoding");
		System.out.println("Header shows some value--"+headerValue4);
		System.out.println("*****************************************");
	}
	
	@Test
	public void AllResponseFrom_HeaderAndBody() {
		// Print all response of Header & body from API
		System.out.println("All get reponse from Header & Body --> ");
		RestAssured.given().get("https://reqres.in/api/users?page=2").then().log().all();
		System.out.println("*****************************************");
	}
	
	@Test
	public void NoidewiseResponsefromJsonBody() {		
		// Node wise response getting from Body of API
		RestAssured.baseURI= "https://reqres.in/api/users";
		RestAssured.given();
		Response responseoBody  = RestAssured.get("?page=2");	
		JsonPath JsonBodyContain = responseoBody.jsonPath();
		String BodyConatindemail = JsonBodyContain.get("data[0].email");
		System.out.println("Body Email response-->"+BodyConatindemail);
		System.out.println("*****************************************");
		
		String BodyConatindavatar = JsonBodyContain.get("data[4].avatar");
		System.out.println("Body avatar response-->"+BodyConatindavatar);
		System.out.println("*****************************************");
		
		String BodyConatindad = JsonBodyContain.get("ad.company");
		System.out.println("Body ad response-->"+BodyConatindad);
		System.out.println("*****************************************");
	}	
}
