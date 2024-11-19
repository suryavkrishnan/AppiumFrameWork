package org.PageObject;

import org.Utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions
{
	 AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	

	@FindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femalelField;
	
	@FindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleField;


	@FindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement country1;
	
	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	
	
	
	
	public void setNameField(String name)
	{
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender)
	{
		if(gender.contains("female"))
		{
			femalelField.click();
		}
		else
			maleField.click();
			
	}
	public void setCountry(String country)
	{
		country1.click();
		scrollToText(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
		

		
	}
	public ProductCatalogPage submitForm() throws InterruptedException
	{
		shopButton.click();
	//	Thread.sleep(2000);
		return new ProductCatalogPage(driver);// create object of new page
	}
	
	public void setHomepageAcitvity()
	{   //Package and Activity
		//after each test page set to home page
		Activity activity=new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
		
	}
	
	
	
}
