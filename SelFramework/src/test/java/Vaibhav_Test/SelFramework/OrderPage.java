package Vaibhav_Test.SelFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class OrderPage extends AbstractComp {

	WebDriver driver;
	OrderPage(WebDriver driver)
	{	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement>productsNames;
	
	
	
	public boolean verfiyOrderDisplay(String productname)
	{
		boolean match=productsNames.stream().
				anyMatch(productsName->productsName.getText().
						equalsIgnoreCase(productname));
		return match;

	}
	
	
	
	
	
	
}
