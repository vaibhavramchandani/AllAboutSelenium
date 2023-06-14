package Vaibhav_Test.SelFramework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class StandAloneTest2 extends BaseTest {

	@Test(dataProvider="getData")
	public void submitOrder(HashMap<String,String>input) throws IOException, InterruptedException {

		// TODO Auto-generated method stub
//		String productname = "zara coat 3";
//		String email = "vaibhav20@gmail.com";
//		String password = "Vaibhav@20";
		ProductCatlogue productcat = firstpage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productcat.getList();
		productcat.addProductToCart( input.get("productname"));
		CartPage cart = productcat.goToCartPage();
		CheckoutPage checkout = cart.checkCartList(input.get("productname"));
		String country = "ind";
		checkout.selectcountry(country);
		OrderConfirmation orderConfirm = checkout.goToOrderConfirmation();
		String message = orderConfirm.getmessage();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		String productname = "zara coat 3";
		String email = "vaibhav20@gmail.com";
		String password = "Vaibhav@20";
		ProductCatlogue productcat = firstpage.loginApplication(email, password);
		OrderPage orderpage=productcat.goToOrdersPage();
		boolean match=orderpage.verfiyOrderDisplay(productname);
		Assert.assertTrue(match);
	}
	
	public String getScreenshot(String testcaseName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>>data=getJsonDataToMap();
		return new Object [][] {{data.get(0)},{data.get(1)}};
		
	}

}
