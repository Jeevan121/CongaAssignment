package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.utils.BasePage;

public class MyAccountPage extends BasePage{
	
	WebDriver driver;
	public MyAccountPage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	By tShirtsLnk= new By.ByXPath("(//a[@title='T-shirts'])[position()=2]");
	
	public CategoryPage clickOnTshirtsLnk(){
		safeClick(tShirtsLnk);
		return new CategoryPage(driver);
	}

}
