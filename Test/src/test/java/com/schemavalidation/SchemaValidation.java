package com.schemavalidation;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath ;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class SchemaValidation {
	
	@Test
	
private void test() {
		
		// schema
		//third
		
		baseURI ="https://reqres.in/api";
		
		Response response = get("/users?page=2");
		
		 given().
		get("/users?page=2").then().assertThat( ).
		body(matchesJsonSchemaInClasspath("schema.json"));
		 
		
	}
	
		
	
	
}
