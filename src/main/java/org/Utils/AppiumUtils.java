package org.Utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.fasterxml.jackson.core.type.TypeReference;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.ObjectMapper;



public abstract class AppiumUtils
{
	
	public AppiumDriverLocalService service;
	
	public Double getFormattedAmount(String amount)
	{
		Double pr=Double.parseDouble(amount.substring(1));
		return pr;
	}
	
	//to automatically invoke the server 
	public AppiumDriverLocalService StartAppiumServer(String ipAddress,int port) throws MalformedURLException
	{
		//to automatically invoke the server using pgm insted of manually by following code.but this code not working in this program.so run servermanually
//				service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Owner\\AppData\\Roaming\\npm\node_modules\\appium\\build\\lib\\main.js"))
//						.withIPAddress(ipAddress).usingPort(port).build();
//				return service;
				
				service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Owner\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
						.withIPAddress("192.168.2.21").usingPort(4723).build();
						service.start();
						return service;
				
				
	}
	
	
	
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException
	{
		//convert json file to json string
		//String jsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\org\\appiumProject\\TestData\\eCommerce.json"),StandardCharsets.UTF_8);
		//OR
		String jsonContent=FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
				
		//String jsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\org\\appiumProject\\TestData\\eCommerce.json"),StandardCharsets.UTF_8);
//		String jsonContent=FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent,new TypeReference<List<HashMap<String, String>>>(){});
		
		return data;
	}
	
	
	
	public void WaitForElementToAppear(WebElement ele,AppiumDriver  driver)
	{
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele),"text","Cart"));
						
		
		
	}
	
	public String getScreenShotPath(String testCaseName,AppiumDriver  driver) throws IOException
	{
		File source=driver.getScreenshotAs(OutputType.FILE);
		String destintnPath=System.getProperty("user.dir")+"//report//images//"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destintnPath));
        return destintnPath;
	}

}
