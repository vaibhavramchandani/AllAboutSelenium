package Vaibhav_Test.SelFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComp {

	 WebDriver driver;

	 
	 
	public AbstractComp(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);

	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
	//		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	
	
	public void waitForTheElementToAppear(By findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	
	public void waitForTheWebElementToAppear(WebElement errorMessage)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf((WebElement) errorMessage));
	}
	
	
	
	
	public void waitForTheElementToDisappear(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	//driver.findElement(By.xpath("//button[.='Checkout']")).click();
	public CartPage goToCartPage()
	{
		cartButton.click();
		CartPage cart=new CartPage(driver);
		return cart;
	}
	
	public OrderPage goToOrdersPage()
	{
		orderHeader.click();
		OrderPage cartpage=new OrderPage(driver);
		return cartpage;
	}
	
	

}
