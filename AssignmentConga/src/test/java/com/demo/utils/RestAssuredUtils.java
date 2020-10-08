package com.demo.utils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtils {
	Response response;
	public Response getRequest(String endPoint,String apiKey){
		RestAssured.baseURI=endPoint;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.queryParam("q",AutomationConstants.q) 
                .queryParam("appid",apiKey).request(Method.GET);
		//response=httpRequest.request(Method.GET);
		return response;
	}
	
	
	public Response postRequest(String endPoint,String apiKey,String jsonrequest){
		RestAssured.baseURI=endPoint;
		RequestSpecification httpRequest = RestAssured.given();
		 httpRequest.header("Content-Type", "application/json");
		httpRequest.body(jsonrequest);
		Response response = httpRequest.queryParam("q",AutomationConstants.q) 
                .queryParam("appid",apiKey) 
                .post();
		return response;
	}
	
	public Response deleteRequest(String endPoint,String apiKey){
		
		 RestAssured.baseURI = endPoint;
		 RequestSpecification httpRequest = RestAssured.given(); 
		 
		 // Add a header stating the Request body is a JSON
		 httpRequest.header("Content-Type", "application/json"); 
		 
		       // Delete the request and check the response
		 //Response res = request.delete("/delete/"+id); 
		 Response res = httpRequest.queryParam("q",AutomationConstants.q) 
	                .queryParam("appid",apiKey).request(Method.DELETE);
		 return res;
	}

}
