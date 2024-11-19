package org.AppiumTestCases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.PageObject.CartPage;
import org.PageObject.FormPage;
import org.PageObject.ProductCatalogPage;
import org.appiumProject.TestUtils.AppiumBaseTest;
import org.appiumProject.TestUtils.AppiumBaseTest2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class eCommerce_TC7_Properties extends AppiumBaseTest2{
	
	@BeforeMethod
	public void preSetup()
	{   
		formPage.setHomepageAcitvity();
		
	}
	@Test(dataProvider="getData")
	public void fillForm(String name,String gender ,String country) throws MalformedURLException, InterruptedException
	{
		
		formPage.setNameField(name);
		formPage.setGender(gender);
		formPage.setCountry(country);
		
		
		//Thread.sleep(2000);
		ProductCatalogPage productCatalog = formPage.submitForm();
		productCatalog.addItemTocartbyIndex(0);
		productCatalog.addItemTocartbyIndex(0);
		
		
		CartPage cartPage=productCatalog.openCart();
		Thread.sleep(2000);
		//WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		//cartPage.WaitForElementToAppear(ele, driver);
	    Double totSum=cartPage.getProductSum();
		Double displySum=cartPage.getTotalamoutDisplyed();
		displySum=7899.45;
		Assert.assertEquals(totSum, displySum);
		cartPage.acceptTerms();
		cartPage.submitOrder();
		
		/*
			
		WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		*/
		
		Thread.sleep(2000);
		
		
	}

	
	// for data provider
	@DataProvider
	public Object[][] getData() throws IOException
	{
				
		return new Object[][] {{"Surya Krishnan","female","Argentina"},{"Surya Pran","male","Armenia"}}; //to get data direct  from array
		
		
		
	}
		
	
	
}
