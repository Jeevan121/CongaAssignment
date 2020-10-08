package com.demo.utils;

public class AutomationConstants {
	
	public static String applicationUrl = PropertiesUtils.initEnvironmentProperties().getProperty("environmentUrl");
	public static String apiEndPoint = PropertiesUtils.initEnvironmentProperties().getProperty("apiEndPoint");
	public static String apiKey = PropertiesUtils.initEnvironmentProperties().getProperty("api-key");
	
	public static String browserType = PropertiesUtils.initAutomatioProperties().getProperty("BrowserType");
	
	public static String firefox="firefox";
	public static String chrome="chrome";
	
	public static String q="London,UK";
	
	/*public static String apiEmpResource="employees";
	public static String apiEmpCreate="/create";*/
	


}
