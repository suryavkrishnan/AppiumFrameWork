package org.PageObject;

import java.util.List;

import org.Utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartPage extends AndroidActions
{
	
	AndroidDriver driver;
	public CartPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
	@FindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalSum;
	
	@FindBy(id="android:id/button1")
	public WebElement acceptButton;
	
	@FindBy(className="android.widget.CheckBox")
	private WebElement checkBox;
	
	@FindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedButton;
	
//	@FindBy(id="com.androidsample.generalstore:id/termsButton")
//	private WebElement terms;
//	
	
	public void acceptTerms()
	{   WebElement terms=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")); //@findby not work in the case of gesture functions
		longPressAction(terms);
		acceptButton.click();
		
	}
	
	public List<WebElement> getProductList()
	{
		return productList;
	}
	
	public double getProductSum()
	{
		
		int pcount=productList.size();
		Double sum=0.0;
		for(int i=0;i<pcount ;i++)
		{
			String priceString=productList.get(i).getText();
			Double pr=getFormattedAmount(priceString);
			sum=sum+pr;
		}
		
		
		return sum;
		
	}
	
	public double getTotalamoutDisplyed()
	{
		String sumString=totalSum.getText();
		Double tot=getFormattedAmount(sumString);
		return tot;
	}
	

	
	public void submitOrder()
	{
		
		checkBox.click();
		proceedButton.click();
	}
	
		
	

}
