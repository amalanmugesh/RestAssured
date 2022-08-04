package com.testcodes;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Excelutils;
import com.utils.utils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;


public class Login {

   static String excelpath ="C:\\\\Users\\\\E008832\\\\eclipse-workspace\\\\TestingProject\\\\utils\\\\Exceldata.xlsx";
   
   utils utils = new utils();
   
	@Test 
	private void TestGet() {
		
	    //login 

		Response response = get("https://reqres.in/api/users?page=2");
		 
		System.out.println(response.asString());	
		System.out.println("Status Code"+response.getStatusCode());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Response Body "+response.getBody().asString());
    
		// get the particular index value using given 
		baseURI ="https://reqres.in/api";

		get("/users?page=2").then().body("data.id[3]",equalTo(10)).
		log().body();

		get("https://reqres.in/api/users?page=2").
		then().
		body("data.last_name",hasItems("Fields","Howell")).
		log().body();


		// using query parameters get the body 

		given().queryParam("id","7")
		.queryParam("email","michael.lawson@reqres.in")
		.when().get("https://reqres.in/api/users?page=2").then().log()
		.body();

		// Get the headers

		get("https://reqres.in/api/users?page=2").then().log()
		.headers();

		get("https://reqres.in/api/users?page=2").then().log()
		.body();
		
		given().body("data[1].first_name").
		when().get("users?page=2").then().statusCode(200);
		

	}

	@Test
	private void testpost() throws IOException {
		
		//Post using  Map
		//		Map<String, Object> map = new HashMap<String, Object>();
		//
		//		map.put("name", "mugesh");
		//		map.put("job", "Engineer");
			
			
		for (int i = 1; i < excelpath.valueOf(true).length(); i++) {
			
		JSONObject response = new JSONObject();
		System.out.println(response);
		
		Excelutils excel = new Excelutils(excelpath, "sheet1");

		
		// post without using map 
		response.put(excel.getcellvalue(0, 0), excel.getcellvalue(0, i));
		response.put(excel.getcellvalue(1, 0), excel.getcellvalue(1, i));

		System.out.println(response);
		
		given().
		contentType(ContentType.JSON).
		body(response.toJSONString())
		.when()
		.post("/users").then()
		.statusCode(201).
		log();
		}
	}

	@Test

	private void test_put() {

		// put (update the values )
		JSONObject response = new JSONObject();
		
		response.put("name", "karthi");

		given().
		contentType(ContentType.JSON).
		body(response.toJSONString())
		.when()
		.put("/users/2").then().statusCode(200).
		log();

	}





}
