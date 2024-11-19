package org.AppiumTestCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.appiumProject.TestUtils.AppiumBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.android.*;

public class eCommerce_TC1_TestDiffrntPage extends AppiumBaseTest{
	
	@BeforeMethod
	public void preSetup()
	{   //Package and Activity
		//after all test page set to home page
		Activity activity=new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
		
	}

//BOTH Test cases will work
	
	@Test
	public void fillForm_ErrorValidation() throws MalformedURLException
	{
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul shetty");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
		//Verifying  For toast message
		String toastMsg=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		//Assert.assertEquals(toastMsg, "Please  your name");
		Assert.assertEquals(toastMsg, "Please enter your name");
		
		
	}
		
		@Test
		public void fillForm_PositiveFlow() throws MalformedURLException
		{
			
			driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul shetty");
			driver.hideKeyboard();
			driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
			driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
			driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			
			
			//Verifying  For toast message
		Assert.assertTrue(driver.findElements(By.xpath("//android.widget.Toast[1]")).size()<1);
	
			
			
		}
	


	
	
}
