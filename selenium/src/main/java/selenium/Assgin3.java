package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assgin3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.crome.driver","D:\\CP\\VAIBHAV\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.findElement(By.id("checkBoxOption2")).click();
		String selected=driver.findElement(By.xpath("//label[@for='benz']")).getText();
		System.out.println(selected);
		WebElement staticdropdown=driver.findElement(By.id("dropdown-class-example"));
		Select options=new Select(staticdropdown);
		options.selectByVisibleText(selected);
		driver.findElement(By.id("name")).sendKeys(selected);
		driver.findElement(By.id("alertbtn")).click();
		String message=driver.switchTo().alert().getText();
		System.out.println(message);
		if(message.contains(selected))
			System.out.println("true");
		else
			System.out.println("false");
		driver.switchTo().alert().accept();
		
		

	}

}
