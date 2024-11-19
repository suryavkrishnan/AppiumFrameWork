package org.PageObject;

import java.util.List;

import org.Utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductCatalogPage extends AndroidActions
{
	AndroidDriver driver;
	public ProductCatalogPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addCart; // it means return 0th element from a list of element .So used List<>
	
	@FindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement openCart;
	
	public void addItemTocartbyIndex(int indx)
	{
		addCart.get(indx).click();
	}
	
	public CartPage openCart()
	{
		openCart.click();
		return new CartPage(driver);
	}
	
}
