package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.crome.driver","D:\\CP\\VAIBHAV\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password=getPassword(driver);
		System.out.println(password);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String name="vaibhav";
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		System.out.println(driver.findElement(By.cssSelector("h2")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("h2")).getText(),"Hello "+name+",");
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[contains(@class,'logout')]")).click();
		driver.close();
	}
		
		public static String getPassword(WebDriver driver) throws InterruptedException
		{
			driver.get("https://rahulshettyacademy.com/locatorspractice/");
			driver.findElement(By.linkText("Forgot your password?")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//form/div/button[2]")).click();
			String textpassword=(driver.findElement(By.className("infoMsg")).getText());
			String [] passwordArray=textpassword.split("'");
			String answer=passwordArray[1].split("'")[0];
			return answer;
			
		}
}
