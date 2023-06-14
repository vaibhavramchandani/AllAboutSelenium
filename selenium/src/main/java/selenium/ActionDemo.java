package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.crome.driver","D:\\CP\\VAIBHAV\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.get("https://www.amazon.com/");
		Actions a=new Actions(driver);
		//a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		//a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		a.moveToElement(driver.findElement(By.className("blinkingText"))).click().build().perform();
		Set<String>tabs=driver.getWindowHandles();
		Iterator<String>it=tabs.iterator();
		String paremtId=it.next();
		String childID=it.next();
		driver.switchTo().window(childID);
		Thread.sleep(7000);
		String[] s=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at");
		String[]f=s[1].split("with");
		String req=f[0].trim();
		System.out.println(req);
		driver.switchTo().window(paremtId);
		Thread.sleep(7000);

		driver.findElement(By.id("username")).sendKeys(req);
		
	}

}
