package Vaibhav_Test.SelFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComp{

	WebDriver driver;
	LandingPage(WebDriver driver)
	{	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));

	@FindBy(id="userEmail")
	WebElement userEmail;
	//driver.findElement(By.id("userPassword")).sendKeys("Vaibhav@20");
	@FindBy(id="userPassword")
	WebElement userPassword;
	//driver.findElement(By.id("login")).click();
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(id="toast-container")
	WebElement errorMessage;
	
	public ProductCatlogue loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		ProductCatlogue pro=new ProductCatlogue(driver);
		return pro;
		
	}
	
	public String getErrorMessage()
	{	waitForTheWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
}
