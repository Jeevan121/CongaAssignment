package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.demo.dataprovider.DataProviderUtils;
import com.demo.utils.BaseTest;

public class Scenario1Test extends BaseTest{
	
	@BeforeTest
	public void setUp(){
		launchApplication();
	}
	
	@Test(dataProviderClass=DataProviderUtils.class,dataProvider="Scenario1",enabled=true,alwaysRun=true)
	public void scenario1Test(String email_ID,String	password,String	succussMessage,String	prdName,String	prdColorSize,String	quantity,String	cartTotal){
		getLoginPage().loginIntoApplication(email_ID, password)
		.clickOnTshirtsLnk().clickOnSleeveShortLnk().addProductIntoCart();
		
		
		String succussFully=getCategoryPage().getSuccussFullyAddedProductIntoCart();
		Assert.assertEquals(succussFully,succussMessage,"the product name is not added into cart");
		
		getCategoryPage().clickOnProceedCheckoutBtk();
		
		String productName=getOrderPage().getProductName();
		Assert.assertEquals(productName,prdName,"the product name is not matching");
		
		String colorSize=getOrderPage().getColorSize();
		Assert.assertEquals(colorSize,prdColorSize,"the product color and size is not matching");
		
		String quanti=getOrderPage().getQuantity();
		Assert.assertEquals(quanti,quantity,"the quantity is not matching");
		
		String crtTotal=getOrderPage().getCartTotal();
		Assert.assertEquals(crtTotal,cartTotal,"the cart total is not matching");
	}
	
	@AfterTest
	public void tearDown(){
		getDriver().quit();
	}
	

}
