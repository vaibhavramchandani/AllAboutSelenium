package Vaibhav_Test.SelFramework;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class ErrorValidation extends BaseTest {

	@Test(groups={"Error"},retryAnalyzer=Retry.class)
	public void checkError() throws IOException, InterruptedException {

		// TODO Auto-generated method stub
		String productname = "zara coat 3";
		String email = "vaibhav20@gmail.com";
		String password = "Vaibha20";
		ProductCatlogue productcat = firstpage.loginApplication(email, password);
		Assert.assertEquals("Incorrect email  password.",firstpage.getErrorMessage());
		
	}

}
