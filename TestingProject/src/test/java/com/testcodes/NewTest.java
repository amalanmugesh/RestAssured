package com.testcodes;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath ;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;


import org.testng.annotations.Test;

public class NewTest {
	
	//test

	@Test
	
	private void test() {
		
		baseURI ="https://reqres.in/api";
		
		 given().
		get("/users?page=2").then().assertThat().
		body(matchesJsonSchemaInClasspath("schema.json"));
		 
		
	}
	
	
}
