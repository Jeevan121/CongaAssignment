package com.demo.dataprovider;

import java.io.File;

import org.testng.annotations.DataProvider;

import com.demo.utils.ExcelUtils;




public class DataProviderUtils {
	
	@DataProvider(name = "Scenario1")
	  public static Object[][] Scenario1() {
	    final Object[][] objReturn = ExcelUtils.getTableArray(
	        System.getProperty("user.dir") +File.separator+"testdata"+File.separator+"Automation_Test_Input_Data.xls", "Demo", "Scenario1");
	    return objReturn;
	  }
	
	@DataProvider(name = "InvalidAPIKeyRestAPIDemoTest")
	  public static Object[][] invalidAPIKeyRestAPIDemoTest() {
	    final Object[][] objReturn = ExcelUtils.getTableArray(
	        System.getProperty("user.dir") +File.separator+"testdata"+File.separator+"Automation_Test_Input_Data.xls", "Demo", "InvalidAPIKeyRestAPIDemoTest");
	    return objReturn;
	  }
	
	@DataProvider(name = "RegStationAPITest1")
	  public static Object[][] regStationAPITest() {
	    final Object[][] objReturn = ExcelUtils.getTableArray(
	        System.getProperty("user.dir") +File.separator+"testdata"+File.separator+"Automation_Test_Input_Data.xls", "Demo", "RegStationAPITest1");
	    return objReturn;
	  }
	
	
}
