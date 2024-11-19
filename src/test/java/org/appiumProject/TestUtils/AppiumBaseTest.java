package org.appiumProject.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.PageObject.FormPage;
import org.Utils.AppiumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.*;
import io.appium.java_client.android.options.*;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class AppiumBaseTest extends AppiumUtils {
	
	

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	public FormPage formPage;
	
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws IOException 
	{
				
		//service=StartAppiumServer("192.168.2.21",4723);
					
		UiAutomator2Options options=new UiAutomator2Options(); //used for android device
		options.setDeviceName("SuryaEmulator"); // put device details
				
		options.setApp("C:\\Users\\Owner\\eclipse-AppiumProject\\AppiumBasic2\\src\\test\\java\\resources\\General-Store.apk");
			
		//driver=new AndroidDriver(new URL("http://192.168.2.13:4723/"), options); // This port getting by running appium server
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/"), options); // This port getting by running appium server
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage=new FormPage(driver);
		
	}
	

	
	
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
		//service.stop();
	}

}
