package com.demo.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.demo.dataprovider.DataProviderUtils;
import com.demo.utils.AutomationConstants;
import com.demo.utils.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class Scenario3Test extends BaseTest{
	
		@Test(dataProviderClass=DataProviderUtils.class,dataProvider="InvalidAPIKeyRestAPIDemoTest",enabled=true,alwaysRun=true)
		public void inavalidApiKeyDemoTest(String keys,String	values){

			HashMap<String, String> reqMap = getJsonUtils().getFramedJsonReqMap(keys,values);
			
			String jsonReq = getJsonUtils().frameJsonRrquest(reqMap);
			
			Response res=getRestAssuredUtils().postRequest(AutomationConstants.apiEndPoint,"9e0b0330a1cf86f79dc7da46d261ecd34", jsonReq);
			System.out.println(res.asString());
			
			JSONObject resObj = getJsonUtils().parseJsonResponse(res);
			String codActual = resObj.get("cod").toString().trim();
			Assert.assertEquals(codActual,"401","the status code is not matching");
			Assert.assertEquals(resObj.get("message").toString().trim(),"Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.","the message is not matching");
		}
	
	@Test(dataProviderClass=DataProviderUtils.class,dataProvider="RegStationAPITest1",enabled=true,alwaysRun=true)
	public void regStationAPITest(String externalId,String	name) throws ParseException, IOException{
	
		
		String stationNme= name+BaseTest.getRandomNumber();
		Reporter.log("The station name is::"+stationNme);
		
		//framing the request hash map
		HashMap<String, String> reqMap = getJsonUtils().getFramedJsonReqMap(externalId,stationNme);
		Reporter.log("The station name is::"+reqMap);
		//Framing the request json object
		String jsonReq = getJsonUtils().frameJsonRrquest(reqMap);
		Reporter.log("The framed request json  is::"+jsonReq);
		Response res=getRestAssuredUtils().postRequest(AutomationConstants.apiEndPoint,AutomationConstants.apiKey, jsonReq);
		//validating the status code should be 201
		Assert.assertEquals(res.getStatusCode(),201,"the status code is not matching");
		
		// parsing the response json file and validating the station name and external id against with test input data
		JsonNode node=new ObjectMapper().readTree(res.asString());
		List<JsonNode>nameNode=node.findValues("name");
		String statnName = nameNode.get(0).asText();
		Assert.assertEquals(statnName, stationNme,"the station name is not matching");
		List<JsonNode>externalID=node.findValues("external_id");
		String extrnalId = externalID.get(0).asText();
		Assert.assertEquals(extrnalId, externalId,"the external id  is not matching");
		
		// getting the id from the response
		List<JsonNode>nodeId=node.findValues("ID");
		String id1 = nodeId.get(0).asText();
		Reporter.log("The Id ::"+id1);
		//Based on newly created station's id hitting to the server and getting the station details
		Response getRes = getRestAssuredUtils().getRequest(AutomationConstants.apiEndPoint+"/"+id1,AutomationConstants.apiKey);
		
		// parsing the get response json file and validating the station name and external id against with test input data
		JsonNode getResNode=new ObjectMapper().readTree(getRes.asString());
		List<JsonNode>getResNameNode=getResNode.findValues("name");
		String getResStatnName = getResNameNode.get(0).asText();
		Assert.assertEquals(getResStatnName, stationNme,"the station name is not matching");
		
		List<JsonNode>getResExternalIDNode=node.findValues("external_id");
		String getResExtrnalId = getResExternalIDNode.get(0).asText();
		Assert.assertEquals(getResExtrnalId, externalId,"the external id  is not matching");
		
		//Based on newly created station's id deleting the newly created station and validing the response code should be 204
		Response deleteRes = getRestAssuredUtils().deleteRequest(AutomationConstants.apiEndPoint+"/"+id1,AutomationConstants.apiKey);
		Assert.assertEquals(deleteRes.getStatusCode(), 204,"the deleted response code is not matching");
		
		//After deleting the station and again hitting to server based on the same station id and then validating status code should be 404
		Response getRes1 = getRestAssuredUtils().getRequest(AutomationConstants.apiEndPoint+"/"+id1,AutomationConstants.apiKey);
		Assert.assertEquals(getRes1.getStatusCode(),404,"the  response code is not matching");

	}
		
}


