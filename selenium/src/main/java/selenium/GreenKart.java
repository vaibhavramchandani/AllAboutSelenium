package selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.crome.driver","D:\\CP\\VAIBHAV\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String[] itemsneeded= {"Cucumber","Brocolli"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		addItems(driver,itemsneeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(.,'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulsheetyacamdey");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());
		
	}
	
	public static void addItems(WebDriver driver, String[] itemsneeded)
	{
		List<WebElement>products=driver.findElements(By.cssSelector("h4.product-name"));
		int j=0;
		for(int i=0;i<products.size();i++)
		{
			String[] name=products.get(i).getText().split("-");
			String reqname=name[0].trim();
			List<String>itemsneededList =Arrays.asList(itemsneeded);
			if(itemsneededList.contains(reqname))
			{	
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				j++;
				if(j==itemsneeded.length)
					break;
			}
		}
	}

}
