package com.demo.utils;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import com.demo.pages.CategoryPage;
import com.demo.pages.LoginPage;
import com.demo.pages.MyAccountPage;
import com.demo.pages.OrderPage;



public class BaseTest {
	
	private WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	CategoryPage categoryPage;
	OrderPage orderPage;
	
	RestAssuredUtils restAssuredUtlis;
	JsonUtils jsonUtils;
	
	public void launchApplication(){
		driver=new BrowserCreation().createBrowser();
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public BasePage getBasePage() {
	    if (basePage == null) {
	      basePage = new BasePage(driver);
	    }
	    return basePage;
	}
	
	public LoginPage getLoginPage() {
	    if (loginPage == null) {
	    	loginPage = new LoginPage(driver);
	    }
	    return loginPage;
	}
	
	public MyAccountPage getMyAccountPage() {
	    if (myAccountPage == null) {
	    	myAccountPage = new MyAccountPage(driver);
	    }
	    return myAccountPage;
	}
	
	public CategoryPage getCategoryPage() {
	    if (categoryPage == null) {
	    	categoryPage = new CategoryPage(driver);
	    }
	    return categoryPage;
	}
	
	public OrderPage getOrderPage() {
	    if (orderPage == null) {
	    	orderPage = new OrderPage(driver);
	    }
	    return orderPage;
	}
	
	public RestAssuredUtils getRestAssuredUtils(){
		if(restAssuredUtlis==null){
			restAssuredUtlis = new RestAssuredUtils();
		}
		return restAssuredUtlis;
	}
	
	public JsonUtils getJsonUtils(){
		if(jsonUtils==null){
			jsonUtils = new JsonUtils();
		}
		return jsonUtils;
	}
	
	public static int getRandomNumber(){
		  Random rand = new Random(); 
	      int rand_int1 = rand.nextInt(1000);
	      return rand_int1;
	}
	
	
}
