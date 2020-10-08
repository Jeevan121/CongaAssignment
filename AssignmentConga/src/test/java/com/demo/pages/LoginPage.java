package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.utils.BasePage;

public class LoginPage extends BasePage{
	WebDriver driver;
	public LoginPage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	By signInBtn = new By.ByClassName("login");
	By emailIDTxt = new By.ById("email");
	By passwordTxt = new By.ById("passwd");
	By loginBtn = new By.ByXPath("//button[@id='SubmitLogin']");
	
	public MyAccountPage loginIntoApplication(String emailID,String password){
		safeClick(signInBtn);
		safeType(emailIDTxt, emailID);
		safeType(passwordTxt, password);
		safeClick(loginBtn);
		return new MyAccountPage(driver);
		
	}

}
