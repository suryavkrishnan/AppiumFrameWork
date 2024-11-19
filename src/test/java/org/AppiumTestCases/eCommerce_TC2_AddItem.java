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

public class eCommerce_TC2_AddItem extends AppiumBaseTest
{
	

	
	@Test
	public void SubmitForm() throws MalformedURLException, InterruptedException //To run this code the application should be start at Home page
	{
		
		driver.hideKeyboard();
		formPage.setNameField("Rahul shetty");
		formPage.setGender("Female");
		formPage.setCountry("Argentina");
		ProductCatalogPage p=formPage.submitForm();
		
		
	}
	
	@Test
	public void AddItem() throws MalformedURLException, InterruptedException
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
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
		
		
	}
	
	
	
	
	/*
	@Test
	public void Old_Method() throws MalformedURLException, InterruptedException
	{
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul shetty");
		driver.hideKeyboard();
//		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
//		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
//		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
//		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();//bze get[0]  first item chnge into "added to cart".so there is no more than one item with "Add To CART".so raise bug
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(1000);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
		
//Calculate total sum of items		
		List<WebElement> productNum=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		
		int pcount=productNum.size();
		Double sum=0.0;
		for(int i=0;i<pcount ;i++)
		{
			String priceString=productNum.get(i).getText();
			Double pr=getFormattedAmount(priceString);
			sum=sum+pr;
		}
		
//Validate diaplyed Total sum with calculated totalsum		
		String sumString=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double tot=getFormattedAmount(sumString);
		Assert.assertEquals(sum, tot);
		
//longpress		
		WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		//longPressAction(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		
		Thread.sleep(10000);
		
		
		
	}
*/

	
	
}
