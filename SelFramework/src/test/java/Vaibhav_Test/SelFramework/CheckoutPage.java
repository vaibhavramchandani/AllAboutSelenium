package Vaibhav_Test.SelFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutPage extends AbstractComp {

	WebDriver driver;
	CheckoutPage(WebDriver driver)
	{	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryselect;
	
	
	@FindBy(css=".list-group span")
	List<WebElement> countries;

	//driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy(css=".action__submit")
	WebElement checkoutButton;

	

	public void selectcountry(String coun) throws InterruptedException
	{	
		countryselect.sendKeys(coun);
		for (WebElement country : countries) {
			if (country.getText().equalsIgnoreCase("India")) {
				country.click();
				break;
			}
		}
		Thread.sleep(3000);
	}
	

	
	public OrderConfirmation goToOrderConfirmation()
	{
		checkoutButton.click();
		OrderConfirmation order=new OrderConfirmation(driver);
		return order;
	}
	
	
	
	
	
	
	
}
