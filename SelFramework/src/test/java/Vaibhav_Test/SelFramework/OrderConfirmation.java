package Vaibhav_Test.SelFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class OrderConfirmation extends AbstractComp {

	WebDriver driver;
	OrderConfirmation(WebDriver driver)
	{	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css=".hero-primary")
	WebElement confmssg;
	
	
	public String getmessage()
	{
		return confmssg.getText();
	}

	
	
	
	
	
	
	
	
}
