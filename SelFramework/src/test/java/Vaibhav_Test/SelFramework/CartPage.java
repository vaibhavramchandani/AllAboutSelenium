package Vaibhav_Test.SelFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends AbstractComp {

	WebDriver driver;
	CartPage(WebDriver driver)
	{	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@class='cartSection']/h3")
	List<WebElement>cartproducts;
	
	@FindBy(xpath="//button[.='Checkout']")
	WebElement checkoutButton;
	
	public CheckoutPage checkCartList(String productname)
	{
		boolean match=cartproducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(match);
		checkoutButton.click();
		CheckoutPage checkout = new CheckoutPage(driver);
		return checkout;
	}
	
	
	
	
	
	
}
