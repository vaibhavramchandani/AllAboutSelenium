package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class NewDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.crome.driver", "D:\\CP\\VAIBHAV\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(4000);
		WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByIndex(2);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for (int i = 0; i < 2; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(4000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class*='ui-menu-item'] a"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("india")) {
				option.click();
				break;
			}
		}
		Thread.sleep(4000);
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		// System.out.println(driver.findElements(By.cssSelector("input[type*='checkbox']")).size());
		// Assert.assertEquals(driver.findElements(By.cssSelector("input[type*='checkbox']")).size(),
		// 6);
		driver.findElement(By.className("ui-datepicker-trigger")).click();
		Thread.sleep(3000);
		// driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		// .ui-state-default.ui-state-highlight.ui-state-active
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
//		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
//		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
//		{
//			Assert.assertTrue(true);
//		}
//		else
//		{
//			Assert.assertTrue(false);
//		}
		Thread.sleep(5000);
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for (int i = 0; i < 2; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}
}
