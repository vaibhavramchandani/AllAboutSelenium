package Vaibhav_Test.SelFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductCatlogue extends AbstractComp {

	WebDriver driver;
	ProductCatlogue(WebDriver driver)
	{	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	//	List<WebElement>products=driver.findElements(By.className("mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement>products;
	
	By productsBy=By.cssSelector(".mb-3");
	By cart=By.cssSelector("#toast-container");
	@FindBy(css=".ng-animating")
	WebElement ngcart;
	
	public List<WebElement> getList()
	{
		waitForTheElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productname)
	{
		WebElement prod=products.stream()
		.filter(product->product.findElement(By.tagName("b"))
		.getText().equalsIgnoreCase(productname)).findFirst().orElse(null);
		return prod;
	}

	public void addProductToCart(String productname)
	{   WebElement prod=getProductByName(productname);
		prod.findElement(By.cssSelector(".card-body button:last-child")).click();
		waitForTheElementToAppear(cart);
		waitForTheElementToDisappear(ngcart);
	}
}
