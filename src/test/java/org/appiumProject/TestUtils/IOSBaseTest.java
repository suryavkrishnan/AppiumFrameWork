package org.appiumProject.TestUtils;

import java.io.File;
import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.*;
import io.appium.java_client.android.options.*;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.net.URL;
import java.time.Duration;

public class IOSBaseTest {
	public IOSDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException 
	{
			
//To run Appium server directly from Eclipse and without cmd prompt use following code
//				service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Owner\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//				.withIPAddress("10.0.0.242").usingPort(4723).build();
//				service.start();

		
	       	XCUITestOptions options = new XCUITestOptions(); // it can use bze xcuitest driver alredy installed
	       	options.setDeviceName("iPhone 12 pro"); // phone name
	       	options.setApp("C:\\UIKitCatalog.app"); //given the path of .app file
	       	options.setPlatformVersion("12.5");//phone version
	       	options.setWdaLaunchTimeout(Duration.ofSeconds(20) );  // add timme for web driver agent to load
		
		
	//Run the appium server first and send port and mobile details as below
				driver=new IOSDriver(new URL("http://127.0.0.1:4723/"), options); // This port getting by running appium server
				//driver=new AndroidDriver(new URL("http://192.168.2.13:4723/"), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
    }
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		//service.stop();
	}

}

