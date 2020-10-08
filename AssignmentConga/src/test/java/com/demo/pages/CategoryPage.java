package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.utils.BasePage;

public class CategoryPage extends BasePage{
	WebDriver driver;
	public CategoryPage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	By sleeveShortLnk = new By.ByXPath("//a[text()='Short Sleeve']/parent::*/parent::*//input");
	
	By fadedShortSleeveTshirtsLnk = new By.ByXPath("(//a[@title='Faded Short Sleeve T-shirts'])[position()=1]");
	
	By addToCardBtn = new By.ByXPath("//a[@title='Add to cart']");
	
	By proceedCheckoutBtn = new By.ByXPath("//a[@title='Proceed to checkout']");
	
	
	By succussfullyAddedIntoCart = new By.ByXPath("//i[@class='icon-ok']/parent::*");
	
	public CategoryPage clickOnSleeveShortLnk(){
		moveToElementAndClick(sleeveShortLnk);
		return this;
	}
	
	public CategoryPage addProductIntoCart(){
		mouseOver(fadedShortSleeveTshirtsLnk);
		safeClick(addToCardBtn);
		return this;
	}
	
	public CategoryPage clickOnProceedCheckoutBtk(){
		safeClick(proceedCheckoutBtn);
		return this;
	}
	
	public String getSuccussFullyAddedProductIntoCart(){
		String succussfully = getText(succussfullyAddedIntoCart).trim();
		return succussfully;
	}
	
	

}
