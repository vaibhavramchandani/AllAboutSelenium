package Vaibhav_Test.SelFramework;

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

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.crome.driver","D:\\CP\\VAIBHAV\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		String productname="zara coat 3";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://rahulshettyacademy.com/client/");
		LandingPage firstpage=new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("vaibhav20@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Vaibhav@20");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));


		List<WebElement>products=driver.findElements(By.className("mb-3"));
		System.out.println(products.size());
		WebElement prod=products.stream()
				.filter(product->product.findElement(By.tagName("b"))
				.getText().equalsIgnoreCase(productname)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-child")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		//ng-animating

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement>cartproducts=driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
		boolean match=cartproducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//button[.='Checkout']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		List<WebElement>countries=driver.findElements(By.cssSelector(".list-group span"));
		System.out.println(countries.size());
		for(WebElement country:countries)
		{
			if(country.getText().equalsIgnoreCase("India"))
			{
				country.click();
				break;
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confmssg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confmssg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}

}
