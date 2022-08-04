package com.testcodes;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class SOAPxmlrequest {
	
	@Test
	public void soapXml() throws IOException {
		
		baseURI = "http://www.dneonline.com";
		
		File file = new File("utils\\calculator.xml");
		FileInputStream fls = new FileInputStream(file);
		String requestbody = IOUtils.toString(fls, "UTF-8");
		
		given().contentType("text/xml")
		   .accept(ContentType.XML)
		.body(requestbody).when().post("/calculator.asmx?op=Add")
		   .then()
		.statusCode(200).log().body();
		
		
		
		
		
		
		
		
	}

}
