package org.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidActions extends AppiumUtils
{
	AndroidDriver driver;
	public AndroidActions(AndroidDriver driver)
	{  
		this.driver=driver;
		
	}
	
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript(
	            "mobile: longClickGesture",
				ImmutableMap.of(
								"elementId",((RemoteWebElement)ele).getId(),
								"duration",2000
								)
				);
	}
	
	
	public void scrollToEndAction()
	{
		boolean canScrollMore;
		do
		{
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 100, "height", 100,
			    "direction", "down",
			    "percent", 3.0
			));
		 
    	}while(canScrollMore);
		
	}
	

	public void scrollToText(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
	}
	
	
	public void swipeAction(WebElement firstpic,String direction)
	{
				((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			"elementId",((RemoteWebElement)firstpic).getId(),
		    "direction", direction,
		    "percent", 0.75
		));
	}
	
	public void dragDropAction(WebElement source)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 613,
			    "endY", 543
			));
	}
	
	

	

}
