package selenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Streams {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.crome.driver","D:\\CP\\VAIBHAV\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//th[1]")).click();
		List<WebElement>items=driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<String>orglist=items.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String>sortedlist=orglist.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(orglist.equals(sortedlist));
		List<String>prices;
		
		do{
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

		prices = rows.stream().filter(s -> s.getText().contains("Rice"))

		.map(s -> getPriceVeggie(s)).collect(Collectors.toList());

		prices.forEach(a -> System.out.println(a));

		if(prices.size()<1)

		{

		driver.findElement(By.cssSelector("[aria-label='Next']")).click();

		}

		}while(prices.size()<1);



		}
	

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String ans=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return ans;
	}

}
