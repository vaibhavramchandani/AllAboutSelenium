package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;


public class Assgin1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.crome.driver","D:\\CP\\VAIBHAV\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
//		driver.findElement(By.linkText("Multiple Windows")).click();
//		driver.findElement(By.linkText("Click Here")).click();
//		Set<String>tabs=driver.getWindowHandles();
//		Iterator<String>it=tabs.iterator();
//		String parentId=it.next();
//		String childId=it.next();
//		driver.switchTo().window(childId);
//		System.out.println(driver.findElement(By.tagName("h3")).getText());
//		driver.switchTo().window(parentId);
//		System.out.println(driver.findElement(By.tagName("h3")).getText());
		driver.findElement(By.linkText("Nested Frames")).click();
		driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.id("content")));
		
	}

}
