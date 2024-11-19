package org.AppiumTestCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.PageObject.CartPage;
import org.PageObject.FormPage;
import org.PageObject.ProductCatalogPage;
import org.appiumProject.TestUtils.AppiumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.android.*;

public class eCommerce_TC3_SumITems extends AppiumBaseTest
{

	@Test
	public void SumItem() throws MalformedURLException, InterruptedException
	{
		
		driver.hideKeyboard();
		formPage.setNameField("Surya");
		formPage.setGender("Female");
		formPage.setCountry("Argentina");
		ProductCatalogPage productPage=formPage.submitForm();
		productPage.addItemTocartbyIndex(0);
		productPage.addItemTocartbyIndex(0);
		CartPage cartPage=productPage.openCart();
			
		Thread.sleep(1000);
		WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		cartPage.WaitForElementToAppear(ele, driver);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele),"text","Cart"));
		
		
//Calculate total sum of items		
		cartPage.getProductList();
		double sum=cartPage.getProductSum();
		double tot=cartPage.getTotalamoutDisplyed();
//Validate diaplyed Total sum with calculated totalsum		
		Assert.assertEquals(sum, tot);
		cartPage.submitOrder();
	}
	
	
	
}
