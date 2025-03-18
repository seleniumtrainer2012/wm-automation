package com.ubs.wmautomation.testcases;

import java.util.List;
import java.util.Properties;

import org.json.JSONObject;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.util.Assert;
import com.ubs.wmautomation.libs.Web;
import com.ubs.wmautomation.util.DataReader;
import com.ubs.wmautomation.util.Reporting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Books_API_Tests extends BaseTest {
	ExtentReports extent=Reporting.getInstance();
	@Test
	public void Validate_Books_Title_Testcase() throws Exception {
		ExtentTest test=extent.createTest("Validate_Books_Title_Testcase");
		//code
		Web.launchBrowser("Chrome");
				
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		
		Response booksGetResponse=RestAssured.get();
		test.log(Status.INFO, "api response "+booksGetResponse.prettyPrint());
		
		int actualStatusCode=booksGetResponse.getStatusCode();
		if (actualStatusCode== 200) {
			test.pass("actual status code is "+actualStatusCode+", expected is 200");
		
			JsonPath jsonPathEvaluator=booksGetResponse.getBody().jsonPath();
			List<Object> bookTitlesList=jsonPathEvaluator.getList("books.title");
			
			System.out.println(bookTitlesList.toString());	
			
			
			test.log(Status.INFO, "all title values "+bookTitlesList);
		
		}else{
			test.fail("actual status code is "+actualStatusCode+", expected is 200");
		};
		
		extent.flush();
	}


	@Test
	public void Post_Call_Testcase() throws Exception {
		ExtentTest test=extent.createTest("Validate_Books_Title_Testcase");
		//code
		Web.launchBrowser("Chrome");
		
		//initlise baseuri
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books/BookStoreV1BooksPost"; 
		RequestSpecification request = RestAssured.given();
		
		//form request payload
		JSONObject requestParams = new JSONObject(); 
		requestParams.put("userId", "TQ123"); 
		requestParams.put("isbn", "9781449325862"); 
		
		// Add a header stating the Request body is a JSON 
		request.header("Content-Type", "application/json"); // Add the Json to the body of the request 
		request.body(requestParams.toString()); // Post the request and check the response
		
		Response response=request.post();
		System.out.println(response.statusCode());
		
		System.out.println(response.asPrettyString());
		
		if (response.statusCode()== 200) {
			test.pass("actual status code is "+response.statusCode()+", expected is 200");
			
			test.log(Status.INFO, "all title values "+response.prettyPrint());
		
		}else{
			test.fail("actual status code is "+response.statusCode()+", expected is 200");
			test.log(Status.INFO, "all title values "+response.prettyPrint());
			
		};
	
		extent.flush();
	}




}
