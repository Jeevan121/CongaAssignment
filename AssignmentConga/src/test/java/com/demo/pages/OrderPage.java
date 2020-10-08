package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.utils.BasePage;

public class OrderPage extends BasePage{
	WebDriver driver;
	public OrderPage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	By productName= new By.ByXPath("//td[@class='cart_description']/p[@class='product-name']/a");
	
	By colorSize= new By.ByXPath("//td[@class='cart_description']//small/a");
	
	By quantityTxt= new By.ByXPath("//input[@class='cart_quantity_input form-control grey']");
	
	By cartTotal= new By.ByXPath("//td[@class='cart_total']/span");
	
	
	public String getProductName(){
		String prdName = getText(productName).trim();
		return prdName;
	}
	
	public String getColorSize(){
		String prdName = getText(colorSize).trim();
		return prdName;
	}
	
	public String getQuantity(){
		String quantity = getAttributeValues(quantityTxt, "value");
		return quantity;
	}
	
	public String getCartTotal(){
		String prdName = getText(cartTotal).trim();
		return prdName;
	}

}
